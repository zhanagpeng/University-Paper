package com.zp.basic.order.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**

 * @author  zp

 * @create  2022/2/25 21:37

 * @desc    保存订单请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderRequest {
    /**
     * 细单保存请求
     */
    @Valid
    @NotEmpty(message = "saveOrderItemRequestList不能为空")
    private List<SaveOrderItemRequest> saveOrderItemRequestList;


}
