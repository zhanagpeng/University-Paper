package com.zp.basic.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zp
 * @create 2022/2/28 22:28
 * @desc 订单详情VO类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVo {

    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 购买数量
     */
    private BigDecimal num;
    /**
     * 商品单价
     */
    private BigDecimal productMoney;
    /**
     * 细单总金额
     */
    private BigDecimal orderItemAmount;
    /**
     * 仓库名称
     */
    private String warehouseName;
}
