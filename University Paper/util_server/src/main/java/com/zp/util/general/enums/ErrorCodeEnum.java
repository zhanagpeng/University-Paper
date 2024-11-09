package com.zp.util.general.enums;

/**
 * @author zp
 * @create 2021/7/21 10:22
 * @desc 异常状态码枚举
 **/
public enum ErrorCodeEnum {

    TIMEOUT("111", "登录超时"),

    SYSERROR("500", "系统异常"),

    NULLERROR("112", "输入不能为空");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
