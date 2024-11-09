//package com.zp.basic.order.controller;
//
//import com.zp.basic.order.biz.OrderBiz;
//import com.zp.basic.order.request.SaveOrderRequest;
//import com.zp.basic.order.request.ShowMyOrderRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Map;
//
///**
//
// * @author  zp
//
// * @create  2022/2/25 21:22
//
// * @desc    订单控制层
//
// **/
//@RestController
//@RequestMapping("/orderController")
//public class OrderController {
//
//    private OrderBiz orderBiz;
//
//    public OrderController(OrderBiz orderBiz) {
//        this.orderBiz = orderBiz;
//    }
//
//    /**
//     * 保存订单
//     * @param saveOrderRequest
//     * @return
//     */
//    @PostMapping(value = "/saveOrder.json")
//    public Map<String,Object> saveOrder(@RequestBody SaveOrderRequest saveOrderRequest){
//        return  orderBiz.saveOrder(saveOrderRequest);
//    }
//
//    /**
//     * 查看我的订单
//     * @param showMyOrderRequest
//     * @return
//     */
//    @PostMapping(value = "/showMyOrder.json")
//    public Map<String,Object> showMyOrder(@RequestBody ShowMyOrderRequest showMyOrderRequest ){
//        return  orderBiz.showMyOrder(showMyOrderRequest);
//    }
//
//    /**
//     * 支付订单
//     * @param orderIds
//     * @return
//     */
//    @PostMapping(value = "/payOrder.json")
//    public Map<String,Object> payOrder(@RequestBody List<String> orderIds ){
//        return  orderBiz.payOrder(orderIds);
//    }
//
//    /**
//     * 取消订单
//     * @param orderIds
//     * @return
//     */
//    @PostMapping(value = "/cancelOrder.json")
//    public Map<String,Object> cancelOrder(@RequestBody List<String> orderIds ){
//        return  orderBiz.cancelOrder(orderIds);
//    }
//
//    /**
//     * 查看订单详情
//     * @param orderId
//     * @return
//     */
//    @PostMapping(value = "/showOrderDetail.json")
//    public Map<String,Object> showOrderDetail(@RequestBody String orderId ){
//        return  orderBiz.showOrderDetail(orderId);
//    }
//
//
//
//}
