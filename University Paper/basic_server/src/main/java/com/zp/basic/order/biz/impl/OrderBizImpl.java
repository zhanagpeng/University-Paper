//package com.zp.basic.order.biz.impl;
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.zp.basic.notice.vo.NoticePageVo;
//import com.zp.basic.order.biz.OrderBiz;
//import com.zp.basic.order.model.Order;
//import com.zp.basic.order.model.OrderItem;
//import com.zp.basic.order.request.SaveOrderItemRequest;
//import com.zp.basic.order.request.SaveOrderRequest;
//import com.zp.basic.order.request.ShowMyOrderRequest;
//import com.zp.basic.order.service.OrderItemService;
//import com.zp.basic.order.service.OrderService;
//import com.zp.basic.order.vo.OrderDetailVo;
//import com.zp.basic.product.dto.CartDto;
//import com.zp.basic.product.dto.CartItemDto;
//import com.zp.basic.product.dto.ProductStockDto;
//import com.zp.basic.product.engine.model.ProductIndex;
//import com.zp.basic.product.engine.service.ProductIndexService;
//import com.zp.basic.product.model.Product;
//import com.zp.basic.product.service.ProductService;
//import com.zp.basic.warehouse.service.WarehouseService;
//import com.zp.util.general.enums.OrderStatusEnum;
//import com.zp.util.general.enums.WarehouseCodeEnum;
//import com.zp.util.general.response.CommonResponse;
//import com.zp.util.general.util.*;
//import io.jsonwebtoken.lang.Assert;
//import io.netty.util.internal.ObjectUtil;
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import redis.clients.jedis.Jedis;
//
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @author zp
// * @create 2022/2/25 21:34
// * @desc 订单核心业务实现层
// **/
//@Service
//public class OrderBizImpl implements OrderBiz {
//    private OrderService orderService;
//    private WarehouseService warehouseService;
//    private ProductIndexService productIndexService;
//    private ProductService productService;
//    private OrderItemService orderItemService;
//
//    public OrderBizImpl(OrderService orderService, WarehouseService warehouseService, ProductIndexService productIndexService, ProductService productService, OrderItemService orderItemService) {
//        this.orderService = orderService;
//        this.warehouseService = warehouseService;
//        this.productIndexService = productIndexService;
//        this.productService = productService;
//        this.orderItemService = orderItemService;
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> saveOrder(SaveOrderRequest saveOrderRequest) {
//        List<OrderItem> orderItems = new ArrayList<>();
//        //处理成有效购买细单
//        this.handleStockProduct(saveOrderRequest, orderItems);
//        //存入订单表
//        this.saveOrderDb(orderItems);
//        //存入细单表
//        this.saveOrderItemDb(orderItems);
//        //删除购物车对应商品
//        this.deleteCartItem(saveOrderRequest);
//        //扣减库存
//        this.deductingTheStock(orderItems);
//        //刷新缓存和ES
//        List<String> productIds = orderItems.stream().map(orderItem -> orderItem.getProductId()).collect(Collectors.toList());
//        if(CollectionUtils.isNotEmpty(productIds)){
//            List<Product> products = productService.selectProductByIds(productIds);
//            this.saveBatchProductToRedisAndEs(products);
//        }
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    public Map<String, Object> showMyOrder(ShowMyOrderRequest showMyOrderRequest) {
//        String userId = ContextUtils.getUserId();
//        IPage<Order> orderIPage = new Page<>(showMyOrderRequest.getPageIndex(), showMyOrderRequest.getPageSize());
//        IPage<Order> orderIPages=orderService.selectPageOrderByUserIdAndOrderNum(orderIPage,userId,showMyOrderRequest.getOrderNum(),showMyOrderRequest.getStatus());
//        return CommonResponse.setResponseData(orderIPages);
//    }
//
//    @Override
//    public Map<String, Object> payOrder(List<String> orderIds) {
//        List<Order> orderList = orderService.selectOrderById(orderIds);
//        if(CollectionUtils.isNotEmpty(orderList)){
//            orderList.stream().forEach(order -> {
//                order.setStatus(OrderStatusEnum.WAIT_DELIVER.getCode());
//                orderService.updateOrder(order);
//            });
//        }
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> cancelOrder(List<String> orderIds) {
//        orderService.deleteOrderById(orderIds);
//        orderItemService.deleteByOrderId(orderIds);
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> showOrderDetail(String orderId) {
//        List<OrderDetailVo> orderItems=orderItemService.selectByOrderDetailOrderId(orderId);
//        return CommonResponse.setResponseData(orderItems);
//    }
//
//    private void saveBatchProductToRedisAndEs(List<Product> products) {
//        products.stream().forEach(product -> {
//            this.saveProductToRedisAndEs(product);
//        });
//    }
//    private void saveProductToRedisAndEs(Product product) {
//        //计算库存
//        this.handleProductStock(product);
//        //计算索引的库存和金额
//        ProductIndex productIndex = this.handleIndexProductStockAndMoney(product);
//        //更新缓存
//        String key = JedisUtil.buildKey(JedisUtil.PRODUCT_KEY, product.getProductId());
//        JedisUtil.getJedis().set(key, JSON.toJSONString(product));
//        //更新索引
//        productIndexService.saveProductIndex(productIndex);
//    }
//
//    private ProductIndex handleIndexProductStockAndMoney(Product product) {
//        Long stock = MyBigDecimalUtil.multiply(product.getStock());
//        Long money = MyBigDecimalUtil.multiply(product.getProductMoney());
//        ProductIndex productIndex = BeanUtil.convert(product, ProductIndex.class, Product.STOCK, Product.PRODUCT_MONEY);
//        productIndex.setStock(stock);
//        productIndex.setProductMoney(money);
//        return productIndex;
//    }
//    private void handleProductStock(Product product) {
//        List<String> id = new ArrayList<>();
//        id.add(product.getProductId());
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(id);
//        if (CollectionUtils.isNotEmpty(productStockDtoList)) {
//            ProductStockDto productStockDto = productStockDtoList.get(0);
//            product.setStock(productStockDto.getStock());
//        }
//    }
//
//    private void deductingTheStock(List<OrderItem> orderItems) {
//        if (CollectionUtils.isNotEmpty(orderItems)) {
//            orderItems.stream().forEach(orderItem -> {
//                warehouseService.deductingTheStockByProductIdAndWarehouseId(orderItem.getProductId(),orderItem.getWarehouseId(),orderItem.getNum());
//            });
//        }
//    }
//
//    private void deleteCartItem(SaveOrderRequest saveOrderRequest) {
//        Jedis jedis = JedisUtil.getJedis();
//        List<String> productIds = saveOrderRequest.getSaveOrderItemRequestList().stream().map(saveOrderItemRequest -> saveOrderItemRequest.getProductId()).collect(Collectors.toList());
//        //获取购物车
//        String userId = ContextUtils.getUserId();
//        String key = JedisUtil.buildKey(JedisUtil.CART_KEY, userId);
//        if (jedis.exists(key)) {
//            String json = jedis.get(key);
//            CartDto cartDto = JSON.parseObject(json, CartDto.class);
//            List<CartItemDto> cartItemDtoList = cartDto.getCartItemDtoList();
//            List<CartItemDto> collect = cartItemDtoList.stream().filter(cartItemDto -> !productIds.contains(cartItemDto.getProductId())).collect(Collectors.toList());
//            //赋值过滤已购买商品后的购物车
//            cartDto.setCartItemDtoList(collect);
//            String s = JSON.toJSONString(cartDto);
//            jedis.set(key, s);
//        }
//    }
//
//    private void saveOrderItemDb(List<OrderItem> orderItems) {
//        orderService.insertBatch(orderItems);
//    }
//
//    private void saveOrderDb(List<OrderItem> orderItems) {
//        Order order = new Order();
//        BigDecimal totalAmount = new BigDecimal("0");
//        String orderNumber = OrderUtil.generateOrderNumber();
//        Date nowTime = new Date();
//        for (OrderItem orderItem :
//                orderItems) {
//            totalAmount = totalAmount.add(orderItem.getOrderItemAmount());
//        }
//        order.setOrderNum(orderNumber);
//        order.setStatus(OrderStatusEnum.UNPAID.getCode());
//        order.setOrderAmount(totalAmount);
//        order.setCreateTime(nowTime);
//        order.setUserId(ContextUtils.getUserId());
//        orderService.saveOrder(order);
//        orderItems.stream().forEach(orderItem -> {
//            orderItem.setOrderId(order.getOrderId());
//        });
//    }
//
//
//    private void handleStockProduct(SaveOrderRequest saveOrderRequest, List<OrderItem> orderItems) {
//        //过滤出库存不为0的细单
//        List<SaveOrderItemRequest> list = saveOrderRequest.getSaveOrderItemRequestList();
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(list.stream().map(saveOrderItemRequest -> saveOrderItemRequest.getProductId()).collect(Collectors.toList()));
//        Assert.notEmpty(productStockDtoList, "商品库存都为0");
//        Map<String, ProductStockDto> map = new HashMap<>();
//        productStockDtoList.stream().forEach(productStockDto -> {
//            map.put(productStockDto.getProductId(), productStockDto);
//        });
//        List<SaveOrderItemRequest> collect = list.stream().filter(saveOrderItemRequest -> map.containsKey(saveOrderItemRequest.getProductId())).collect(Collectors.toList());
//        //遍历物料,生成分仓细单，生成规则：仓库1优先满足，其次仓库2。
//        collect.stream().forEach(saveOrderItemRequest -> {
//            OrderItem orderItem;
//            BigDecimal num = saveOrderItemRequest.getNum();
//            BigDecimal stock_beijing = warehouseService.findSockByProductIdAndWarehouseCode(saveOrderItemRequest.getProductId(), WarehouseCodeEnum.BEIJING.getCode());
//            BigDecimal stock_nanjing = warehouseService.findSockByProductIdAndWarehouseCode(saveOrderItemRequest.getProductId(), WarehouseCodeEnum.NANJING.getCode());
//            if (ObjectUtils.isNull(stock_beijing)) {
//                stock_beijing = new BigDecimal("0");
//            }
//            if (ObjectUtils.isNull(stock_nanjing)) {
//                stock_nanjing = new BigDecimal("0");
//            }
//            BigDecimal zero = new BigDecimal("0");
//            if (stock_beijing.compareTo(zero) == 1 && stock_nanjing.compareTo(zero) == 1) {
//                BigDecimal subtract = num.subtract(stock_beijing);
//                //购买数>仓库1库存
//                if (subtract.compareTo(zero) == 1) {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), stock_beijing, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.BEIJING.getId());
//                    orderItems.add(orderItem);
//                    //剩余购买数>仓库2库存
//                    if (subtract.compareTo(stock_nanjing) == 1) {
//                        orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), stock_nanjing, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.NANJING.getId());
//                    } else {
//                        orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), subtract, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.NANJING.getId());
//                    }
//                } else {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), num, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.BEIJING.getId());
//                }
//                orderItems.add(orderItem);
//            } else if (stock_beijing.compareTo(zero) == 1 && stock_nanjing.compareTo(zero) != 1) {
//                BigDecimal subtract = num.subtract(stock_beijing);
//                //购买数>仓库1库存
//                if (subtract.compareTo(zero) == 1) {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), stock_beijing, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.BEIJING.getId());
//                } else {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), num, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.BEIJING.getId());
//                }
//                orderItems.add(orderItem);
//            } else if (stock_beijing.compareTo(zero) != 1 && stock_nanjing.compareTo(zero) == 1) {
//                BigDecimal subtract = num.subtract(stock_nanjing);
//                //购买数>仓库2库存
//                if (subtract.compareTo(zero) == 1) {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), stock_nanjing, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.NANJING.getId());
//                } else {
//                    orderItem = this.generateOrderItem(saveOrderItemRequest.getProductId(), num, saveOrderItemRequest.getProductMoney(), WarehouseCodeEnum.NANJING.getId());
//                }
//                orderItems.add(orderItem);
//            }
//        });
//
//    }
//
//    private OrderItem generateOrderItem(String productId, BigDecimal num, BigDecimal productMoney, String warehouseId) {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProductId(productId);
//        orderItem.setNum(num);
//        //设置总计金额
//        orderItem.setOrderItemAmount(num.multiply(productMoney));
//        orderItem.setWarehouseId(warehouseId);
//        return orderItem;
//    }
//
//
//}
