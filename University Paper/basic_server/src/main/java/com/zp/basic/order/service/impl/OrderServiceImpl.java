package com.zp.basic.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.order.mapper.OrderItemMapper;
import com.zp.basic.order.mapper.OrderMapper;
import com.zp.basic.order.model.Order;
import com.zp.basic.order.model.OrderItem;
import com.zp.basic.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zp
 * @create 2022/2/25 21:42
 * @desc 订单通用业务实现层
 **/
@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;
    private OrderItemMapper orderItemMapper;

    public OrderServiceImpl(OrderMapper orderMapper, OrderItemMapper orderItemMapper) {
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public void saveOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void insertBatch(List<OrderItem> orderItems) {
        orderItems.stream().forEach(orderItem -> {
            orderItemMapper.insert(orderItem);
        });
    }

    @Override
    public IPage<Order> selectPageOrderByUserIdAndOrderNum(IPage<Order> orderIPage, String userId, String orderNum,String status) {
        return orderMapper.selectPageOrderByUserIdAndOrderNum(orderIPage,userId,orderNum,status);
    }

    @Override
    public List<Order> selectOrderById(List<String> orderIds) {
        return orderMapper.selectBatchIds(orderIds);
    }

    @Override
    public void deleteOrderById(List<String> orderIds) {
        orderMapper.deleteBatchIds(orderIds);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateById(order);
    }


}
