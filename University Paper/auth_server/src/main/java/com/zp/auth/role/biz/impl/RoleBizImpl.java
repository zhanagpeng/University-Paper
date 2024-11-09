package com.zp.auth.role.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zp.auth.role.biz.RoleBiz;
import com.zp.auth.role.model.Role;
import com.zp.auth.role.request.RoleAddRequest;
import com.zp.auth.role.request.RolePageRequest;
import com.zp.auth.role.request.RoleUpdateRequest;
import com.zp.auth.role.service.RoleService;
import com.zp.auth.role.vo.RoleDropDownVo;
import com.zp.util.general.enums.SysCodeEnum;
import com.zp.util.general.exception.ZfException;
import com.zp.util.general.response.CommonResponse;
import com.zp.util.general.util.BeanUtil;
import com.zp.util.general.util.DateUtils;
import com.zp.util.general.util.JedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zp
 * @create 2021/12/23 21:56
 * @desc 业务实现层
 **/
@Service
public class RoleBizImpl implements RoleBiz {
    private RoleService roleService;

    public RoleBizImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Map<String, Object> selectAllRoles() {
        List<Role> roleList = roleService.selectAllRoles();
        List<RoleDropDownVo> roleDropDownVoList = BeanUtil.convertList(roleList, RoleDropDownVo.class);
        return CommonResponse.setResponseData(roleDropDownVoList);
    }

    @Override
    public Map<String, Object> selectPageRoles(RolePageRequest rolePageRequest) {
        IPage<Role> rolePage = new Page<>(rolePageRequest.getPageIndex(), rolePageRequest.getPageSize());
        if (StringUtils.isNotBlank(rolePageRequest.getCDate())) {
            String time = rolePageRequest.getCDate().replaceAll("-", "").substring(0, 8);
            String date = String.valueOf(Integer.parseInt(time) + 1);
            rolePageRequest.setCDate(date);
        }
        IPage<Role> result = roleService.selectPageRoles(rolePage, rolePageRequest);
        return CommonResponse.setResponseData(result);
    }

    @Override
    public void addRole(RoleAddRequest roleAddRequest, HttpServletRequest httpServletRequest) {
        //判断该角色名称是否存在
        List<Role> allRoleList = roleService.selectAllRoles();
        allRoleList.stream().forEach(role -> {
            if (StringUtils.equals(role.getRName(), roleAddRequest.getRName())) {
                throw new ZfException("该名称已存在");
            }
        });
        Role role = BeanUtil.convert(roleAddRequest, Role.class);
        String token = httpServletRequest.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        String time = DateUtils.getNowTime();
        String uId;
        try (Jedis jedis = JedisUtil.getJedis()) {
            uId = jedis.get(token);
        }
        roleService.addRole(role);
    }

    @Override
    public void updateRoleById(RoleUpdateRequest roleUpdateRequest) {
        //判断要修改的角色是否存在
        Role role = roleService.selectById(roleUpdateRequest.getRId());
        if (role == null) {
            throw new ZfException("该角色不存在");
        }
        //判断该角色名称是否存在
        if (!StringUtils.equals(role.getRName(), roleUpdateRequest.getRName())) {
            List<Role> allRoleList = roleService.selectAllRoles();
            List<Role> collectRole = allRoleList.stream().filter(roles -> StringUtils.equals(roles.getRName(), roleUpdateRequest.getRName())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(collectRole)) {
                throw new ZfException("该名称已存在");
            }
        }
        role.setRName(roleUpdateRequest.getRName());
        role.setRDesc(roleUpdateRequest.getRDesc());
        roleService.updateRoleById(role);
    }

    @Override
    public void deleteRoleByIds(@NotEmpty(message = "rIds不能为空") String[] rIds) {
        roleService.deleteRoleByIds(rIds);
    }

    @Override
    @Transactional
    public void bindMenus(String[] mIds) {
        String[] real_mid = Arrays.copyOf(mIds, mIds.length - 1);
        String rId = mIds[mIds.length - 1];
        //清除橘色所有菜单
        roleService.deleteBindMenusByRid(rId);
        //绑定菜单
        for (String mId :
                real_mid) {
            roleService.insertBindMenus(mId, rId);
        }
    }
}
