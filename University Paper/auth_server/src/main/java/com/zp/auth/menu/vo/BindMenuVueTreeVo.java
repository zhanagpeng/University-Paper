package com.zp.auth.menu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zp
 * @create 2022/1/2 14:31
 * @desc vue绑定菜单树vo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindMenuVueTreeVo {
    /**
     * 菜单id
     */
    private String id;
    /**
     * 父级菜单ID
     */
    private String pId;
    /**
     * 菜单名称
     */
    private String label;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单描述
     */
    private String desc;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 子菜单
     */
    private List<BindMenuVueTreeVo> children;
}

