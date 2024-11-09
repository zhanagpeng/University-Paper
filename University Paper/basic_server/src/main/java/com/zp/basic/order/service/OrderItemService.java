package com.zp.basic.order.service;

import com.zp.basic.order.vo.OrderDetailVo;

import java.util.List;

/**

 * @author  zp

 * @create  2022/2/28 22:07

 * @desc    订单项通用业务层

 **/
public interface OrderItemService {
    /**
     * 根据订单ID删除细单
     * @param orderIds
     */
    void deleteByOrderId(List<String> orderIds);

    /**
     * 根据订单ID查询订单细单
     * @param orderId
     * @return
     */
    List<OrderDetailVo> selectByOrderDetailOrderId(String orderId);
}
