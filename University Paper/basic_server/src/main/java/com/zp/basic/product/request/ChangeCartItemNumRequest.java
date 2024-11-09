package com.zp.basic.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * @author  zp

 * @create  2022/2/20 19:13

 * @desc    购物车数量变化请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeCartItemNumRequest {
    /**
     * 商品ID
     */
    @NotBlank(message = "productId不能为空")
    private String productId;
    /**
     * 数量
     */
    @NotNull(message = "num不能为空")
    private Integer num;
}
