package com.zp.auth.menu.controller;

import com.zp.auth.menu.biz.MenuBiz;
import com.zp.auth.menu.request.MenuRequest;
import com.zp.auth.menu.vo.BindMenuTreeVo;
import com.zp.auth.menu.vo.MenuVo;
import com.zp.util.general.annotation.PointLog;
import com.zp.util.general.enums.LogTypeEnum;
import com.zp.util.general.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
/**

 * @author  zp

 * @create  2021/12/19 9:53

 * @desc    菜单控制层

 **/
@RestController
@RequestMapping("/menuController")
public class MenuController {
    private MenuBiz menuBiz;

    public MenuController(MenuBiz menuBiz) {
        this.menuBiz = menuBiz;
    }

    /**
     * 根据用户角色获取菜单
     * @param httpServletRequest
     * @return
     */
    @GetMapping(value = "/getMenuByUser.json")
    public Map<String, Object> getMenuByUser(HttpServletRequest httpServletRequest) {
        return menuBiz.getMenuByUser(httpServletRequest);
    }

    /**
     * 菜单管理获取所有菜单
     * @return
     */
    @PointLog(id = LogTypeEnum.MENU_MAN)
    @GetMapping(value = "/selectAllMenus.json")
    public Map<String, Object> selectAllMenus() {
        return menuBiz.selectAllMenus();
    }
    /**
     * 新增菜单
     * @return
     */
    @PostMapping(value = "/addMenu.json")
    public Map<String, Object> addMenu(HttpServletRequest httpServletRequest,@RequestBody MenuRequest menuRequest) {
        return menuBiz.addMenu(httpServletRequest,menuRequest);
    }
    /**
     * 根据ID获取菜单
     * @return
     */
    @GetMapping(value = "/findMenuById.json")
    public Map<String, Object> findMenuById(String id) {
        return menuBiz.findMenuById(id);
    }

    /**
     * 根据ID获取菜单和父菜单
     * @return
     */
    @GetMapping(value = "/findMenuAndParentMenuById.json")
    public Map<String, Object> findMenuAndParentMenuById(String id) {
        return menuBiz.findMenuAndParentMenuById(id);
    }

    /**
     * 根据ID删除菜单
     * @param ids
     * @return
     */
    @PostMapping(value = "/deleteMenuByIds.json")
    public Map<String, Object> deleteMenuByIds(@RequestBody String[] ids) {
        return menuBiz.deleteMenuByIds(ids);
    }

    /**
     * 更新菜单
     * @param menuRequest
     * @return
     */
    @PostMapping(value = "/updateMenu.json")
    public Map<String, Object> updateMenu(HttpServletRequest httpServletRequest,@RequestBody  MenuRequest menuRequest){
        return menuBiz.updateMenu(httpServletRequest,menuRequest);
    }
}
