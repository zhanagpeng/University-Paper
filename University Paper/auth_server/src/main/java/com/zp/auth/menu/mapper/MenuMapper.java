package com.zp.auth.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.auth.menu.dto.MenuAndParentMenuDto;
import com.zp.auth.menu.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**

 * @author  zp

 * @create  2021/12/19 14:00

 * @desc    菜单持久层

 **/
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据rId查找对应权限菜单
     * @param rId
     * @return
     */
    List<Menu> selectMenusByRid(String rId);

    /**
     * 根据ID获取菜单和父菜单
     * @param id
     * @return
     */
    MenuAndParentMenuDto findMenuAndParentMenuById(String id);
}
