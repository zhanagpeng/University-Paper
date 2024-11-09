package com.zp.util.general.enums;

/**
 * @author zp
 * @create 2022/2/26 14:10
 * @desc 仓库枚举
 **/
public enum WarehouseCodeEnum {
    BEIJING("1", "001", "北京供应链"),
    NANJING("2", "002", "南京供应链");
    private String id;
    private String code;
    private String desc;


    WarehouseCodeEnum(String id, String code, String desc) {
        this.id = id;
        this.code = code;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
