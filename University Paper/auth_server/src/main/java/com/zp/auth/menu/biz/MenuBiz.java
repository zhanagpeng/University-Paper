package com.zp.auth.menu.biz;

import com.netflix.ribbon.proxy.annotation.Http;
import com.zp.auth.menu.request.MenuRequest;
import com.zp.auth.menu.vo.BindMenuTreeVo;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**

 * @author  zp

 * @create  2021/12/19 9:55

 * @desc    菜单业务层

 **/
@Validated
public interface MenuBiz {
    /**
     * 根据用户角色获取菜单
     * @param httpServletRequest
     * @return
     */
    Map<String, Object> getMenuByUser(HttpServletRequest httpServletRequest);

    /**
     * 根据rid查找角色绑定菜单
     * @param rId
     * @return
     */
    List<BindMenuTreeVo> getMenuByRid(@NotBlank(message = "rId不能为空") String rId);

    /**
     * 菜单管理获取所有菜单
     * @return
     */
    Map<String, Object> selectAllMenus();

    /**
     * 新增菜单
     * @param httpServletRequest
     * @param menuRequest
     * @return
     */
    Map<String, Object> addMenu(HttpServletRequest httpServletRequest,@Valid MenuRequest menuRequest);

    /**
     * 根据ID获取菜单
     * @param id
     * @return
     */
    Map<String, Object> findMenuById(@NotBlank(message = "id不能为空") String id);

    /**
     * 根据ID删除菜单
     * @param ids
     * @return
     */
    Map<String, Object> deleteMenuByIds(@NotEmpty String[] ids);

    /**
     * 更新菜单
     * @param menuRequest
     * @return
     */
    Map<String, Object> updateMenu(HttpServletRequest httpServletRequest,@Valid MenuRequest menuRequest);

    /**
     * 根据ID获取菜单和父菜单
     * @param id
     * @return
     */
    Map<String, Object> findMenuAndParentMenuById(@NotBlank(message = "ID不能为空") String id);
}
