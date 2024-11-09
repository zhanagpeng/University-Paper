package com.zp.basic.product.request;

import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**

 * @author  zp

 * @create  2022/2/2 16:24

 * @desc    修改商品启用状态请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductStatusRequest {
    /**
     * 待修改商品ID
     */
    @NotEmpty(message = "ids不能为空")
    private String[] ids;
    /**
     * 修改状态,false:停用，true:启用
     */
    @NotNull(message = "flag不能为空")
    private Boolean flag;
}
