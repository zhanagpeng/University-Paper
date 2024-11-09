package com.zp.basic.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zp
 * @create 2022/2/6 21:49
 * @desc 商品库存dto
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDto {
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 库存
     */
    private BigDecimal stock;
}
