package com.zp.auth.menu.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zp
 * @create 2021/8/3 11:27
 * @desc 菜单vo层
 **/
@Data
public class MenuVo {
    //菜单id
    private String mId;
    //菜单图标
    private String mIcon;
    //菜单url
    private String mUrl;
    //菜单名称
    private String mName;
    //子菜单
    private List<MenuVo> subs;

}
