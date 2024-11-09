package com.zp.basic.warehouse.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**

 * @author  zp

 * @create  2022/2/7 12:07

 * @desc    商品仓库绑定关系停启用请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProductWarehouseBindRelRequest {
    /**
     * 商品仓库绑定关系Id
     */
    @NotBlank(message = "productWarehouseId不能为空")
    private String productWarehouseId;
    /**
     * 状态
     */
    @NotBlank(message = "status不能为空")
    private String status;
}
