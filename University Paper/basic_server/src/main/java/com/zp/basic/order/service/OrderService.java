package com.zp.basic.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.order.model.Order;
import com.zp.basic.order.model.OrderItem;

import java.util.List;

/**

 * @author  zp

 * @create  2022/2/25 21:41

 * @desc    订单通用业务层

 **/
public interface OrderService {
    /**
     * 保存订单
     * @param order
     */
    void saveOrder(Order order);

    /**
     * 批量插入订单细单
     * @param orderItems
     */
    void insertBatch(List<OrderItem> orderItems);

    /**
     * 分页查询订单根据用户ID以及订单号
     * @param userId
     * @return
     */
    IPage<Order> selectPageOrderByUserIdAndOrderNum(IPage<Order> orderIPage, String userId, String orderNum,String status);

    /**
     * 根据ID查找订单
     * @param orderIds
     */
    List<Order> selectOrderById(List<String> orderIds);

    /**
     * 根据ID删除订单
     * @param orderIds
     */
    void deleteOrderById(List<String> orderIds);

    /**
     * 更新订单
     * @param order
     */
    void updateOrder(Order order);
}
