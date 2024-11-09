package com.zp.basic.order.biz;

import com.zp.basic.order.request.SaveOrderRequest;
import com.zp.basic.order.request.ShowMyOrderRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**

 * @author  zp

 * @create  2022/2/25 21:24

 * @desc    订单核心业务层

 **/
@Validated
public interface OrderBiz {
    /**
     * 保存订单
     * @param saveOrderRequest
     * @return
     */
    Map<String, Object> saveOrder(@Valid SaveOrderRequest saveOrderRequest);

    /**
     * 查看我的订单
     * @param showMyOrderRequest
     * @return
     */
    Map<String, Object> showMyOrder(@Valid ShowMyOrderRequest showMyOrderRequest);

    /**
     * 支付订单
     * @param orderIds
     * @return
     */
    Map<String, Object> payOrder(@NotEmpty(message = "orderIds不能为空") List<String> orderIds);

    /**
     * 取消订单
     * @param orderIds
     * @return
     */
    Map<String, Object> cancelOrder(@NotEmpty(message = "orderIds不能为空")List<String> orderIds);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    Map<String, Object> showOrderDetail(@NotBlank(message = "orderId不能为空") String orderId);
}
