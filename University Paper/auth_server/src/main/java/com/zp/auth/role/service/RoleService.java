package com.zp.auth.role.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.auth.role.model.Role;
import com.zp.auth.role.request.RolePageRequest;
import com.zp.auth.role.request.RoleUpdateRequest;

import java.util.List;
import java.util.Map;

/**

 * @author  zp

 * @create  2021/12/23 21:58

 * @desc    角色通用业务层

 **/
public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectAllRoles();

    /**
     * 分页动态查询所有角色
     * @param rolePage
     * @param rolePageRequest
     * @return
     */
    IPage<Role> selectPageRoles(IPage<Role> rolePage, RolePageRequest rolePageRequest);

    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据rid查询角色
     * @param rId
     */
    Role selectById(String rId);

    /**
     * 更新角色
     * @param role
     */
    void updateRoleById(Role role);

    /**
     * 根据rid批量删除角色
     * @param rIds
     */
    void deleteRoleByIds(String[] rIds);

    /**
     * 根据rid删除绑定菜单
     * @param rId
     */
    void deleteBindMenusByRid(String rId);

    /**
     * 根据rid绑定菜单
     * @param mId
     * @param rId
     */
    void insertBindMenus(String mId, String rId);
}
