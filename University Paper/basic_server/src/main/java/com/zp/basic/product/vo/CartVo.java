package com.zp.basic.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**

 * @author  zp

 * @create  2022/2/12 16:26

 * @desc    购物车VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVo {
    private List<CartItemVo> cartItemVos;
}
