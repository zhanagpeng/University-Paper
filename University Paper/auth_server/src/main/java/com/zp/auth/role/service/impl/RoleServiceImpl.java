package com.zp.auth.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.auth.role.mapper.RoleMapper;
import com.zp.auth.role.model.Role;
import com.zp.auth.role.request.RolePageRequest;
import com.zp.auth.role.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author zp
 * @create 2021/12/23 21:59
 * @desc 角色通用业务实现层
 **/
@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> selectAllRoles() {
        return roleMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public IPage<Role> selectPageRoles(IPage<Role> rolePage, RolePageRequest rolePageRequest) {
        return roleMapper.selectPageRoles(rolePage, rolePageRequest);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public Role selectById(String rId) {
        return roleMapper.selectById(rId);
    }

    @Override
    public void updateRoleById(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public void deleteRoleByIds(String[] rIds) {
        roleMapper.deleteBatchIds(Arrays.asList(rIds));
    }

    @Override
    public void deleteBindMenusByRid(String rId) {
        roleMapper.deleteBindMenusByRid(rId);
    }

    @Override
    public void insertBindMenus(String mId, String rId) {
        roleMapper.insertBindMenus(mId,rId);
    }
}
