package com.zp.util.general.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @author zp
 * @create 2022/2/12 9:29
 * @desc 消息类型枚举
 **/
public enum ActionTypeEnum {
    PRODUCT_ACTION("PRODUCT", "商品");
    /**
     * 消息编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    ActionTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ActionTypeEnum getByCode(String code) {
        for (ActionTypeEnum actionTypeEnum
                : ActionTypeEnum.values()) {
            if (StringUtils.equals(actionTypeEnum.getCode(), code)) {
                return actionTypeEnum;
            }
        }
        return null;
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
