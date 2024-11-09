package com.zp.basic.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2022/2/9 20:19

 * @desc    添加购物车请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {
    /**
     * 用户ID
     */
    @NotBlank(message = "userId不能为空")
    private String userId;
    /**
     * 商品ID
     */
    @NotBlank(message = "productId不能为空")
    private String productId;
}
