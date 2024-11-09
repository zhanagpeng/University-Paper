package com.zp.auth.user.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zp.auth.user.biz.UserBiz;
import com.zp.auth.user.model.User;
import com.zp.auth.user.request.LoginRequest;
import com.zp.auth.user.request.UserPageRequest;
import com.zp.auth.user.request.UserRequest;
import com.zp.auth.user.service.UserService;
import com.zp.auth.user.vo.UserTokenVo;
import com.zp.util.general.enums.StatusEnum;
import com.zp.util.general.enums.SysCodeEnum;
import com.zp.util.general.exception.ZfException;
import com.zp.util.general.response.CommonResponse;
import com.zp.util.general.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zp
 * @create 2021/12/18 16:39
 * @desc 用户业务实现层
 **/
@Service
@Slf4j
public class UserBizImpl implements UserBiz {
    private UserService userService;

    public UserBizImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Map checkUserLogin(LoginRequest loginRequest) {
        try {
            String uName = loginRequest.getuName();
            String password = loginRequest.getPassword();
            //对密码加密
            String md5Pw = MD5Util.EncoderByMd5(password);
            //根据用户名、密码查询该用户是否存在
            User user = userService.findUserByNameAndPassWord(uName, md5Pw);
            boolean isExist = Optional.ofNullable(user).isPresent();
            if (isExist == false) {
                throw new ZfException("用户名或密码错误");
            }
            //用户名密码正确,判断redis里token是否存在，存在则刷新时间，不存在则新建
            String jwt = JwtUtil.createJWT(user.getuId());
            try(Jedis jedis = JedisUtil.getJedis()){
                jedis.set(jwt, user.getuId());
                jedis.set(user.getuId(), user.getuName());
                jedis.expire(jwt, JwtUtil.TTL_MILLIS);//设置token分钟过期时间
                jedis.expire(user.getuId(), JwtUtil.TTL_MILLIS);
            }
            return CommonResponse.setResponseData(jwt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ZfException("用户名或密码不正确");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ZfException("用户名或密码不正确");
        }
    }

    @Override
    public Map<String, Object> listUser(UserPageRequest userPageRequest) {
        IPage<User> userPage = new Page<>(userPageRequest.getPageIndex(), userPageRequest.getPageSize());
        IPage<User> userIPage = userService.listUser(userPage, userPageRequest);
        return CommonResponse.setResponseData(userIPage);
    }

    @Override
    public Map<String, Object> addOrUpdateUser(@Valid UserRequest userRequest) {
        User convert = BeanUtil.convert(userRequest, User.class);
        String pw=null;
        try {
            pw=MD5Util.EncoderByMd5(userRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ZfException("MD5加密失败");
        }
        convert.setPassword(pw);
        //判断用户名是否存在
        List<User> users = userService.listUsers();
        List<User> collect_user = users.stream().filter(u ->
                StringUtils.equals(u.getuName(), convert.getuName())).collect(Collectors.toList());
        User user = userService.findUserByUid(convert.getuId());
        if (user == null) {//新增
            if (collect_user.size() != 0) {
                throw new ZfException(convert.getuName() + ":用户名已经存在");
            }
            userService.saveUser(convert);
        } else {//更新
            if (collect_user.size() > 1) {
                throw new ZfException(convert.getuName() + ":用户名已经存在");
            }
            user.setrId(convert.getrId());
            user.setEmail(convert.getEmail());
            user.setPhone(convert.getPhone());
            user.setSex(convert.getSex());
            user.setuName(convert.getuName());
            userService.updateUser(user);
        }
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> deleteBatchUser(List<String> uid_list) {
        if (CollectionUtils.isEmpty(uid_list)) throw new ZfException("用户ID不能为空");
        userService.deleteBatchUser(uid_list);
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> findUserByUid(String uId) {
        if (StringUtils.isBlank(uId)) {
            throw new ZfException("uId不能为空");
        }
        User user = userService.findUserByUid(uId);
        return CommonResponse.setResponseData(user);
    }

    @Override
    public Map<String, Object> logOut() {
        //清除redis缓存
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        try(Jedis jedis = JedisUtil.getJedis()){
            String uId = jedis.get(token);
            jedis.del(token, uId);
        }
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> selectAllUser() {
        List<User> list=userService.listUsers();
        return CommonResponse.setResponseData(list);
    }
}
