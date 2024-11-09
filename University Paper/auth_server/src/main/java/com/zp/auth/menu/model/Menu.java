package com.zp.auth.menu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zp.util.general.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zp
 * @create 2021/12/19 13:53
 * @desc 菜单表
 **/
@TableName(value = "t_menu")
public class Menu extends BaseEntity {
    private static final long serialVersionUID = 2893331776391116670L;
    public static final String M_ID = "m_id";
    public static final String M_NAME = "m_name";
    public static final String P_MENU = "p_menu";
    public static final String IS_NAVIGATION = "is_navigation";
    public static final String M_URL = "m_url";
    public static final String M_ICON = "m_icon";
    public static final String M_SORT = "m_sort";
    public static final String M_DESC = "m_desc";
    /**
     * 自定义主键生成策略
     */
    @TableId(type = IdType.UUID)
    private String mId;

    /**
     * 菜单功能名
     */
    private String mName;


    /**
     * 上级功能编号
     */
    private String pMenu;

    /**
     * 是否用于导航（0：是 1：否）
     */
    private String isNavigation;

    /**
     * 菜单URL
     */
    private String mUrl;

    /**
     * 菜单图标
     */
    private String mIcon;

    /**
     * 菜单顺序
     */
    private Integer mSort;

    /**
     * 菜单描述
     */
    private String mDesc;


    public Menu() {
    }


    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getpMenu() {
        return pMenu;
    }

    public void setpMenu(String pMenu) {
        this.pMenu = pMenu;
    }

    public String getIsNavigation() {
        return isNavigation;
    }

    public void setIsNavigation(String isNavigation) {
        this.isNavigation = isNavigation;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public Integer getmSort() {
        return mSort;
    }

    public void setmSort(Integer mSort) {
        this.mSort = mSort;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

}