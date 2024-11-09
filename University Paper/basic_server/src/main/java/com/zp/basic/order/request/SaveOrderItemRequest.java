package com.zp.basic.order.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author zp
 * @create 2022/2/25 22:35
 * @desc 保存细单请求
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderItemRequest {
    /**
     * 商品ID
     */
    @NotBlank(message = "productId不能为空")
    private String productId;

    /**
     * 商品单价
     */
    @NotNull(message = "productMoney不能为空")
    private BigDecimal productMoney;

    /**
     * 购买数量
     */
    @NotNull(message = "num不能为空")
    private BigDecimal num;



}
