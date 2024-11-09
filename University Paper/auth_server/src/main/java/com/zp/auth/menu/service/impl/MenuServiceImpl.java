package com.zp.auth.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zp.auth.menu.dto.MenuAndParentMenuDto;
import com.zp.auth.menu.mapper.MenuMapper;
import com.zp.auth.menu.model.Menu;
import com.zp.auth.menu.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zp
 * @create 2021/12/19 13:49
 * @desc 菜单公共业务实现层
 **/
@Service
public class MenuServiceImpl implements MenuService {
    private MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> selectMenusByRid(String rId) {
        return menuMapper.selectMenusByRid(rId);
    }

    @Override
    public List<Menu> selectAllMenus() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(Menu.M_SORT)
                .orderByDesc(Menu.M_NAME);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public void addMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public Menu findMenuById(String id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<Menu> selectSubMenusById(String id) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Menu.P_MENU, id);
        queryWrapper.orderByAsc(Menu.M_SORT);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteMenuByIds(List<String> ids) {
        menuMapper.deleteBatchIds(ids);
    }

    @Override
    public List<Menu> selectMenuByIds(List<String> collect) {
        return menuMapper.selectBatchIds(collect);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateById(menu);
    }

    @Override
    public MenuAndParentMenuDto findMenuAndParentMenuById(String id) {
        return menuMapper.findMenuAndParentMenuById(id);
    }

    @Override
    public List<Menu> selectMenuByMenuName(String mName) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Menu.M_NAME,mName);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public List<Menu> selectMenuByMenuUrl(String mUrl) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Menu.M_URL,mUrl);
        return menuMapper.selectList(queryWrapper);
    }

}
