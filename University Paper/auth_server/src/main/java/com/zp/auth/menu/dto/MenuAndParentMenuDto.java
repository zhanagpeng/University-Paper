package com.zp.auth.menu.dto;
/**

 * @author  zp

 * @create  2022/1/15 12:16

 * @desc    菜单和父菜单DTO

 **/
public class MenuAndParentMenuDto {
    /**
     * 上级功能名
     */
    private String pMenuName;
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

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private String updateTime;

    public MenuAndParentMenuDto() {
    }

    public MenuAndParentMenuDto(String pMenuName, String mId, String mName, String pMenu, String isNavigation, String mUrl, String mIcon, Integer mSort, String mDesc, String createUser, String createTime, String updateUser, String updateTime) {
        this.pMenuName = pMenuName;
        this.mId = mId;
        this.mName = mName;
        this.pMenu = pMenu;
        this.isNavigation = isNavigation;
        this.mUrl = mUrl;
        this.mIcon = mIcon;
        this.mSort = mSort;
        this.mDesc = mDesc;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public String getpMenuName() {
        return pMenuName;
    }

    public void setpMenuName(String pMenuName) {
        this.pMenuName = pMenuName;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
