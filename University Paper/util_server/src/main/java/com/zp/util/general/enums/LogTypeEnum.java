package com.zp.util.general.enums;

/**

 * @author  zp

 * @create  2022/1/16 21:48

 * @desc    日志类型枚举类

 **/
public enum LogTypeEnum {
    LOGIN("1", "登录"),
    LOGOUT("2", "注销"),
    EMAIL("3", "站内信"),
    PRD_DRAW("4", "商品透视图"),
    INDEX("5", "首页"),
    LOGIN_LOG("6", "登录日志"),
    FUN_LOG("7", "功能日志"),
    ROLE_MAN("8", "角色管理"),
    USER_MAN("9", "用户管理"),
    MENU_MAN("10", "菜单管理"),
    PRODUCT_MANAGER("11", "商品管理"),
    PRODUCT_SHOP("12", "商城"),
    PRD_PRODUCE("13", "商品产量详情");
    private String code;
    private String desc;

    LogTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //根据code获取enum
    public static LogTypeEnum getDescByCode(String code) {
        for (LogTypeEnum l :
                LogTypeEnum.values()) {
            if (l.getCode().equals(code)) {
                return l;
            }
        }
        return null;
    }
}
