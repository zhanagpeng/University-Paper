package com.zp.util.general.enums;

/**
 * @author zp
 * @create 2022/2/26 13:02
 * @desc 订单状态枚举
 **/
public enum OrderStatusEnum {
    UNPAID("0", "未支付"),
    WAIT_DELIVER("1", "待发货"),
    DELIVERED("2", "已发货"),
    PAID("3", "已完成");
    private String code;
    private String desc;

    OrderStatusEnum(String code, String desc) {
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
