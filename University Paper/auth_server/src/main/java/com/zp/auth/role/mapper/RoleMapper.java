package com.zp.auth.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.auth.role.model.Role;
import com.zp.auth.role.request.RolePageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**

 * @author  zp

 * @create  2021/12/23 21:57

 * @desc    角色通用业务实现层

 **/
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 分页动态查询所有角色
     * @param rolePage
     * @param rolePageRequest
     * @return
     */
    IPage<Role> selectPageRoles(@Param("rolePage") IPage<Role> rolePage,@Param("rolePageRequest") RolePageRequest rolePageRequest);

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
    void insertBindMenus(@Param("mId") String mId,@Param("rId") String rId);
}
