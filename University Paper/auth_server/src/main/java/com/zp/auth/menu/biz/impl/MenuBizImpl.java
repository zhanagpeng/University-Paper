package com.zp.auth.menu.biz.impl;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.netflix.ribbon.proxy.annotation.Http;
import com.zp.auth.menu.biz.MenuBiz;
import com.zp.auth.menu.dto.MenuAndParentMenuDto;
import com.zp.auth.menu.model.Menu;
import com.zp.auth.menu.request.MenuRequest;
import com.zp.auth.menu.service.MenuService;
import com.zp.auth.menu.vo.BindMenuTreeVo;
import com.zp.auth.menu.vo.BindMenuVueTreeVo;
import com.zp.auth.menu.vo.MenuAndParentMenuVo;
import com.zp.auth.menu.vo.MenuVo;
import com.zp.auth.user.model.User;
import com.zp.auth.user.service.UserService;
import com.zp.util.general.enums.ErrorCodeEnum;
import com.zp.util.general.enums.SysCodeEnum;
import com.zp.util.general.exception.ZfException;
import com.zp.util.general.response.CommonResponse;
import com.zp.util.general.util.BeanUtil;
import com.zp.util.general.util.DateUtils;
import com.zp.util.general.util.JedisUtil;
import com.zp.util.general.util.MapperFactoryUtil;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zp
 * @create 2021/12/19 9:56
 * @desc 菜单业务实现层
 **/
@Service
@Slf4j
public class MenuBizImpl implements MenuBiz {
    private MenuService menuService;
    private UserService userService;

    public MenuBizImpl(MenuService menuService, UserService userService) {
        this.menuService = menuService;
        this.userService = userService;
    }

    @Override
    public Map<String, Object> getMenuByUser(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        if (StringUtils.isEmpty(token)) {
            throw new ZfException(ErrorCodeEnum.TIMEOUT.getDesc());
        }
        String uId;
        try (Jedis jedis = JedisUtil.getJedis()) {
            //获取uid
            uId = jedis.get(token);
        }
        if (StringUtils.isEmpty(uId)) {
            throw new ZfException(ErrorCodeEnum.TIMEOUT.getDesc());
        }
        User user = userService.findUserByUid(uId);
        if (user == null) {
            throw new ZfException("该用户不存在");
        }
        //根据rid查询菜单
        List<Menu> menus = menuService.selectMenusByRid(user.getrId());
        //获取子菜单
        List<MenuVo> menuVos = this.getSubMenus(menus);
        return CommonResponse.setResponseData(menuVos);
    }

    @Override
    public List<BindMenuTreeVo> getMenuByRid(String rId) {
        //查询所有菜单
        List<Menu> menuList = menuService.selectAllMenus();
        //查询该角色菜单
        List<Menu> menuListByRole = menuService.selectMenusByRid(rId);
        List<BindMenuTreeVo> bindMenuTreeVos = new ArrayList<>();
        menuList.stream().forEach(menu -> {
            BindMenuTreeVo bindMenuTreeVo = new BindMenuTreeVo();
            bindMenuTreeVo.setId(menu.getmId());
            bindMenuTreeVo.setpId(menu.getpMenu());
            bindMenuTreeVo.setName(menu.getmName());
            bindMenuTreeVo.setIcon(menu.getmIcon());
            bindMenuTreeVos.add(bindMenuTreeVo);
        });
        //根节点，二级父节点设置展开,该角色菜单进行默认选中
        bindMenuTreeVos.stream().forEach(menuVo -> {
            if ("0".equals(menuVo.getpId()) || "0".equals(menuVo.getId())) {
                menuVo.setOpen(true);
            }
            for (Menu m :
                    menuListByRole) {
                if (m.getmId().equals(menuVo.getId())) {
                    menuVo.setChecked(true);
                    break;
                }
            }
        });
        return bindMenuTreeVos;
    }

    @Override
    public Map<String, Object> selectAllMenus() {
        List<BindMenuVueTreeVo> collect = new ArrayList<>();
        //查询所有菜单
        List<Menu> menuList = menuService.selectAllMenus();
        List<BindMenuVueTreeVo> bindMenuVueTreeVos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(menuList)) {

            menuList.stream().forEach(menu -> {
                BindMenuVueTreeVo bindMenuVueTreeVo = new BindMenuVueTreeVo();
                bindMenuVueTreeVo.setId(menu.getmId());
                bindMenuVueTreeVo.setLabel(menu.getmName());
                bindMenuVueTreeVo.setPId(menu.getpMenu());
                bindMenuVueTreeVo.setIcon(menu.getmIcon());
                bindMenuVueTreeVo.setDesc(menu.getmDesc());
                bindMenuVueTreeVo.setUrl(menu.getmUrl());
                bindMenuVueTreeVo.setSort(menu.getmSort());
                bindMenuVueTreeVos.add(bindMenuVueTreeVo);
            });
            //生成菜单树
            collect = bindMenuVueTreeVos.stream()
                    // 查找根目录
                    .filter(bm -> StringUtils.equals("0", bm.getId()))
                    // 查找子菜单并放到第一级菜单中
                    .map(bm -> {
                        bm.setChildren(getChildren(bm, bindMenuVueTreeVos));
                        return bm;
                    })
                    // 把处理结果收集成一个 List 集合
                    .collect(Collectors.toList());
        }
        return CommonResponse.setResponseData(collect);
    }

    @Override
    public Map<String, Object> addMenu(HttpServletRequest httpServletRequest, MenuRequest menuRequest) {
        Menu menu = BeanUtil.convert(menuRequest, Menu.class);
        //判断名称是否存在
        List<Menu> menuByMenuName = menuService.selectMenuByMenuName(menu.getmName());
        if (!CollectionUtils.isEmpty(menuByMenuName)) {
            throw new ZfException("该名称已存在");
        }
        //判断URL是都存在
        List<Menu> menuByMenuUrl = menuService.selectMenuByMenuUrl(menu.getmUrl());
        if (!CollectionUtils.isEmpty(menuByMenuUrl)) {
            throw new ZfException("该URL已存在");
        }
        String token = httpServletRequest.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        String uId;
        try (Jedis jedis = JedisUtil.getJedis()) {
            uId = jedis.get(token);
        }
        menu.setCreateTime(new Date());
        menu.setCreateUser(uId);
        menuService.addMenu(menu);
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> findMenuById(@NotBlank(message = "id不能为空") String id) {
        Menu menu = menuService.findMenuById(id);
        if (menu == null) {
            throw new ZfException("该菜单不存在");
        }
        return CommonResponse.setResponseData(menu);
    }

    @Override
    public Map<String, Object> deleteMenuByIds(@NotEmpty String[] ids) {
        //判断该菜单下是否存在子菜单
        List<String> list = Arrays.asList(ids);
        List<String> collect = list.stream().filter(id -> {
            List<Menu> subMenus = menuService.selectSubMenusById(id);
            return !CollectionUtils.isEmpty(subMenus);
        }).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            //查菜单名称
            List<Menu> menus = menuService.selectMenuByIds(collect);
            List<String> menuNames = menus.stream().map(menu -> menu.getmName()).collect(Collectors.toList());
            throw new ZfException(menuNames + "存在子菜单，请先删除子菜单!");
        }
        //取差集
        list.removeAll(collect);
        menuService.deleteMenuByIds(list);
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> updateMenu(HttpServletRequest httpServletRequest, MenuRequest menuRequest) {
        String mId = menuRequest.getmId();
        Assert.hasLength(mId, "id不能为空");
        Menu menu = menuService.findMenuById(mId);
        Assert.notNull(menu, "找不到该菜单");
        //名称不可重复
        checkDuplicateName(menu.getmName(), menuRequest.getmName());
        //url不可重复
        checkDuplicateUrl(menu.getmUrl(), menuRequest.getmUrl());
        //获取当前操作用户
        String token = httpServletRequest.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        Assert.hasLength(token, "token已过期");
        String uId;
        try (Jedis jedis = JedisUtil.getJedis()) {
            uId = jedis.get(token);
        }
        menu.setmDesc(menuRequest.getmDesc());
        menu.setmIcon(menuRequest.getmIcon());
        menu.setIsNavigation(menuRequest.getIsNavigation());
        menu.setmName(menuRequest.getmName());
        menu.setmSort(menuRequest.getmSort());
        menu.setmUrl(menuRequest.getmUrl());
        menu.setUpdateTime(new Date());
        menu.setUpdateUser(uId);
        //更新
        menuService.updateMenu(menu);
        return CommonResponse.setResponseData(null);
    }

    private void checkDuplicateUrl(String oldMenuUrl, String newMenuUrl) {
        if (StringUtils.equals(newMenuUrl, oldMenuUrl)) {
            return;
        }
        List<Menu> menuList = menuService.selectMenuByMenuUrl(newMenuUrl);
        if (!CollectionUtils.isEmpty(menuList)) {
            throw new ZfException("菜单Url已存在！");
        }
    }

    private void checkDuplicateName(String oldMenuName, String newMenuName) {
        if (StringUtils.equals(oldMenuName, newMenuName)) {
            return;
        }
        List<Menu> menuList = menuService.selectMenuByMenuName(newMenuName);
        if (!CollectionUtils.isEmpty(menuList)) {
            throw new ZfException("菜单名称已存在！");
        }
    }

    @Override
    public Map<String, Object> findMenuAndParentMenuById(String id) {
        MenuAndParentMenuDto menuAndParentMenuDto = menuService.findMenuAndParentMenuById(id);
        if (menuAndParentMenuDto == null) {
            throw new ZfException("该菜单不存在");
        }
        MenuAndParentMenuVo menuAndParentMenuVo = BeanUtil.convert(menuAndParentMenuDto, MenuAndParentMenuVo.class);
        return CommonResponse.setResponseData(menuAndParentMenuVo);
    }


    /**
     * 递归获取子菜单
     *
     * @param root 当前菜单
     * @param all  总的数据
     * @return 子菜单
     */
    public List<BindMenuVueTreeVo> getChildren(BindMenuVueTreeVo root, List<BindMenuVueTreeVo> all) {
        List<BindMenuVueTreeVo> children = all.stream()
                // 根据 父菜单 ID 查找当前菜单 ID，以便于找到 当前菜单的子菜单
                .filter(menu -> StringUtils.equals(menu.getPId(), root.getId()))
                // 递归查找子菜单的子菜单
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                // 把处理结果收集成一个 List 集合
                .collect(Collectors.toList());
        return children;
    }


    private List<MenuVo> getSubMenus(List<Menu> menus) {
        //获取一级菜单
        List<Menu> menuList = menus.stream().filter(menu -> "0".equals(menu.getpMenu())).collect(Collectors.toList());
        //一级菜单menuVo
        List<MenuVo> menuVos = BeanUtil.convertList(menuList, MenuVo.class);
        if (menuVos.size() > 0) {
            menuVos.stream().forEach(menuVo -> {
                List<MenuVo> list = new ArrayList<>();
                for (Menu m :
                        menus) {
                    if (menuVo.getMId().equals(m.getpMenu())) {
                        MenuVo vo = new MenuVo();
                        vo.setMIcon(m.getmIcon());
                        vo.setMId(m.getmId());
                        vo.setMUrl(m.getmUrl());
                        vo.setMName(m.getmName());
                        list.add(vo);
                    }
                }
                //存完子菜单清空
                menuVo.setSubs(list);
            });
        }
        return menuVos;
    }
}
