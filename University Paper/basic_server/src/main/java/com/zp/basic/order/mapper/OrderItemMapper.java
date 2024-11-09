package com.zp.basic.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.basic.order.model.OrderItem;
import com.zp.basic.order.vo.OrderDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**

 * @author  zp

 * @create  2022/2/26 20:35

 * @desc    订单细单持久层

 **/
@Repository
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    /**
     * 根据订单ID查询订单细单
     * @param orderId
     * @return
     */
    List<OrderDetailVo> selectByOrderDetailOrderId(String orderId);
}
