package com.zp.auth.user.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp.auth.user.model.User;
import com.zp.auth.user.request.LoginRequest;
import com.zp.auth.user.request.UserPageRequest;
import com.zp.auth.user.request.UserRequest;
import com.zp.auth.user.vo.UserTokenVo;
import com.zp.util.general.enums.StatusEnum;
import com.zp.util.general.response.CommonResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author zp
 * @create 2021/12/18 16:36
 * @desc 用户业务层
 **/
@Validated
public interface UserBiz {

    /**
     * 校验用户登录
     *
     * @param loginRequest
     * @return
     */
    Map checkUserLogin(@Valid LoginRequest loginRequest);

    /**
     * 动态分页查询用户
     * @param userPageRequest
     * @return
     */
    Map<String, Object> listUser(UserPageRequest userPageRequest);

    /**
     * 添加用户
     * @param userRequest
     * @return
     */
    Map<String, Object> addOrUpdateUser(@Valid UserRequest userRequest);

    /**
     * 根据uId批量删除用户
     * @param uid_list
     * @return
     */
    Map<String, Object> deleteBatchUser(List<String> uid_list);

    /**
     * 根据UID查询用户
     * @param uId
     * @return
     */
    Map<String, Object> findUserByUid(String uId);

    /**
     * 用户登出
     * @return
     */
    Map<String, Object> logOut();

    /**
     * 查询所有用户
     * @return
     */
    Map<String, Object> selectAllUser();
}