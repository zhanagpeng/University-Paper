package com.zp.basic.warehouse.request;

import com.zp.basic.product.request.PageIndexRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2022/2/5 15:41

 * @desc    分页查询仓库请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPageWarehouseRequest extends PageIndexRequest {
    /**
     * 商品ID
     */
    @NotBlank(message = "productId不存在")
    private String productId;
    /**
     * 仓库编码
     */
    private String warehouseCode;
}
