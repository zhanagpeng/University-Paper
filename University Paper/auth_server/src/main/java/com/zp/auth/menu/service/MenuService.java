package com.zp.auth.menu.service;

import com.zp.auth.menu.dto.MenuAndParentMenuDto;
import com.zp.auth.menu.model.Menu;
import com.zp.auth.menu.request.MenuRequest;

import java.util.List;

/**

 * @author  zp

 * @create  2021/12/19 10:37

 * @desc    菜单公共业务

 **/
public interface MenuService {
    /**
     * 根据rId查找对应权限菜单
     * @param rId
     * @return
     */
    List<Menu> selectMenusByRid(String rId);

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> selectAllMenus();

    /**
     * 新增菜单
     * @param menu
     */
    void addMenu(Menu menu);

    /**
     * 根据ID获取菜单
     * @param id
     * @return
     */
    Menu findMenuById(String id);

    /**
     * 根据id查找子菜单
     * @param id
     * @return
     */
    List<Menu> selectSubMenusById(String id);

    /**
     * 根据id批量删除菜单
     * @param ids
     */
    void deleteMenuByIds(List<String> ids);

    /**
     * 根据id批量查找菜单
     * @param collect
     * @return
     */
    List<Menu> selectMenuByIds(List<String> collect);

    /**
     * 更新用户
     * @param menu
     */
    void updateMenu(Menu menu);

    /**
     * 根据ID获取菜单和父菜单
     * @param id
     * @return
     */
    MenuAndParentMenuDto findMenuAndParentMenuById(String id);

    /**
     * 根据菜单名称查找菜单
     * @param mName
     * @return
     */
    List<Menu> selectMenuByMenuName(String mName);

    /**
     * 根据Url查找菜单
     * @param mUrl
     * @return
     */
    List<Menu> selectMenuByMenuUrl(String mUrl);

}
