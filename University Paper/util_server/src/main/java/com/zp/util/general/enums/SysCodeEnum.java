package com.zp.util.general.enums;

/**
 * @author zp
 * @create 2022/1/15 11:07
 * @desc 系统枚举类
 **/
public enum SysCodeEnum {
    HEADER_NAME("Authorization", "前端token请求头");

    private String code;
    private String desc;

    SysCodeEnum(String code, String desc) {
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
}
