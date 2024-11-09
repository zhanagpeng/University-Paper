package com.zp.basic.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 * @author  zp

 * @create  2022/2/9 20:55

 * @desc    redis购物车明细项

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 购买数量
     */
    private Integer num;
}
