package com.zp.auth.menu.vo;

import lombok.Data;

/**
 * @author zp
 * @create 2022/1/2 14:31
 * @desc ztree绑定菜单vo
 **/
public class BindMenuTreeVo {
    /**
     * 菜单id
     */
    private String id;
    /**
     * 父级菜单id
     */
    private String pId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 是否默认展开
     */
    private boolean open;

    /**
     * icon图标
     *
     * @return
     */
    private String icon;

    /**
     * 是否选中
     *
     * @return
     */
    private Boolean checked;

    public BindMenuTreeVo() {
    }

    public BindMenuTreeVo(String id, String pId, String name, boolean open, String icon, Boolean checked) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
        this.icon = icon;
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}

