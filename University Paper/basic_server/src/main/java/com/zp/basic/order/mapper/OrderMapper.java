package com.zp.basic.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.order.model.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**

 * @author  zp

 * @create  2022/2/25 21:42

 * @desc    订单持久层

 **/
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 分页查询订单根据用户ID以及订单号
     * @param orderIPage
     * @param userId
     * @param orderNum
     * @return
     */
    IPage<Order> selectPageOrderByUserIdAndOrderNum(@Param("orderIPage") IPage<Order> orderIPage,@Param("userId") String userId,@Param("orderNum") String orderNum,@Param("status") String status);
}
