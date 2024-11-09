package com.zp.util.general.enums;

/**
 * @author zp
 * @create 2022/1/28 15:53
 * @desc 索引枚举类
 **/
public enum IndexEnum {
    PRODUCT_INDEX("product", "商品索引");
    private String code;
    private String desc;

    IndexEnum(String code, String desc) {
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
