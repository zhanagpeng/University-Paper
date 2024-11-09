package com.zp.auth.menu.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * @author  zp

 * @create  2022/1/12 15:38

 * @desc    菜单请求类

 **/
public class MenuRequest {
    private String mId;

    /**
     * 菜单功能名
     */
    @NotBlank(message = "mName不能为空")
    private String mName;


    /**
     * 上级功能编号
     */
    @NotBlank(message = "pMenu不能为空")
    private String pMenu;

    /**
     * 是否用于导航（0：是 1：否）
     */
    private String isNavigation;

    /**
     * 菜单URL
     */
    @NotBlank(message = "mUrl")
    private String mUrl;

    /**
     * 菜单图标
     */
    private String mIcon;

    /**
     * 菜单顺序
     */
    @NotNull(message = "mSort不能为空")
    private Integer mSort;

    /**
     * 菜单描述
     */
    private String mDesc;

    public MenuRequest() {
    }

    public MenuRequest(String mId, String mName, String pMenu, String isNavigation, String mUrl, String mIcon, Integer mSort, String mDesc) {
        this.mId = mId;
        this.mName = mName;
        this.pMenu = pMenu;
        this.isNavigation = isNavigation;
        this.mUrl = mUrl;
        this.mIcon = mIcon;
        this.mSort = mSort;
        this.mDesc = mDesc;
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
