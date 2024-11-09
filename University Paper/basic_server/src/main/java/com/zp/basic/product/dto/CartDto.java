package com.zp.basic.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**

 * @author  zp

 * @create  2022/2/9 20:59

 * @desc    redis购物车DTO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    /**
     * 购物车明细
     */
    private List<CartItemDto> cartItemDtoList;
}
