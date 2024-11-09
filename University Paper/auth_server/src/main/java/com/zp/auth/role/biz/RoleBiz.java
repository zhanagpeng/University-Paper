package com.zp.auth.role.biz;

import com.zp.auth.role.request.RoleAddRequest;
import com.zp.auth.role.request.RolePageRequest;
import com.zp.auth.role.request.RoleUpdateRequest;
import org.springframework.validation.annotation.Validated;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * @author zp
 * @create 2021/12/23 21:55
 * @desc 角色业务层
 **/
@Validated
public interface RoleBiz {
    /**
     * 查询所有角色
     *
     * @return
     */
    Map<String, Object> selectAllRoles();

    /**
     * 分页动态查询所有角色
     * @param rolePageRequest
     * @return
     */
    Map<String, Object> selectPageRoles(RolePageRequest rolePageRequest);

    /**
     * 新增角色
     * @param roleAddRequest
     * @param httpServletRequest
     */
    void addRole(@Valid RoleAddRequest roleAddRequest, HttpServletRequest httpServletRequest);

    /**
     * 根据rid修改角色
     * @param roleUpdateRequest
     */
    void updateRoleById(@Valid RoleUpdateRequest roleUpdateRequest);

    /**
     * 根据rid批量删除角色
     * @param rIds
     */
    void deleteRoleByIds(@NotEmpty(message = "rIds不能为空") String[] rIds);

    /**
     * 绑定菜单
     * @param mIds
     */
    void bindMenus(@NotEmpty(message = "mIds不能为空") String[] mIds);
}
