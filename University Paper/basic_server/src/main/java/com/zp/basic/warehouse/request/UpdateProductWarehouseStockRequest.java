package com.zp.basic.warehouse.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**

 * @author  zp

 * @create  2022/2/6 15:40

 * @desc    更新商品库存请求

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductWarehouseStockRequest {
    /**
     * 商品库存id
     */
    @NotBlank(message = "productWarehouseId不能为空")
    private String productWarehouseId;
    /**
     * 库存
     */
    @NotNull(message = "stock不能为空")
    private BigDecimal stock;
}
