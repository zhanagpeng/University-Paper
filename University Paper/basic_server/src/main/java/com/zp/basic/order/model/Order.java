package com.zp.basic.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zp.util.general.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**

 * @author  zp

 * @create  2022/2/23 12:20

 * @desc    订单实体类

 **/
@TableName(value = "t_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {

    private static final long serialVersionUID = -5854862369292366784L;
    public static final String ORDER_ID="order_id";
    public static final String ORDER_NUM="order_num";
    public static final String ORDER_AMOUNT="order_amount";
    public static final String STATUS="status";
    /**
     * 订单id
     */
    @TableId(type= IdType.UUID)
    private String orderId;
    /**
     * 订单号
     */
    private String orderNum;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态 0：待支付、1：待发货 2：已发货 3：已完成
     */
    private String status;
    /**
     * 创建用户
     */
    private String userId;
}
