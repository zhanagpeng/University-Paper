package com.zp.basic.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zp
 * @create 2022/2/23 12:33
 * @desc 订单细单实体类
 **/
@TableName(value = "order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity {
    private static final long serialVersionUID = -7655480665118815214L;
    public static final String ORDER_ITEM_ID="order_item_id";
    public static final String ORDER_ID="order_id";
    public static final String PRODUCT_ID="product_id";
    public static final String WAREHOUSE_ID="warehouse_id";
    public static final String NUM="num";
    public static final String ORDER_ITEM_AMOUNT="order_itm_amount";
    public static final String DELIVERY_NUM="delivery_num";
    /**
     * 订单细单ID
     */
    @TableId(type=IdType.UUID)
    private String orderItemId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 仓库ID
     */
    private String warehouseId;
    /**
     * 购买数量
     */
    private BigDecimal num;
    /**
     * 发货数量
     */
    private BigDecimal deliveryNum;
    /**
     * 细单总金额
     */
    private BigDecimal orderItemAmount;

}
