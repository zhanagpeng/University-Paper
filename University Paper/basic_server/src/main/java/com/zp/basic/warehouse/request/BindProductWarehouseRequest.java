package com.zp.basic.warehouse.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2022/2/6 15:06

 * @desc    商品绑定仓库请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindProductWarehouseRequest {
    /**
     * 商品主键
     */
    @NotBlank(message = "productId不能为空")
    private String productId;
    /**
     * 仓库主键
     */
    @NotBlank(message = "warehouseId不能为空")
    private String warehouseId;
}
