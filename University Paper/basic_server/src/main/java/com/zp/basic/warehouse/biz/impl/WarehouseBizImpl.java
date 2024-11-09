//package com.zp.basic.warehouse.biz.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.zp.basic.log.vo.FunctionLogPageVo;
//import com.zp.basic.product.dto.ProductStockDto;
//import com.zp.basic.product.engine.model.ProductIndex;
//import com.zp.basic.product.engine.service.ProductIndexService;
//import com.zp.basic.product.model.Product;
//import com.zp.basic.product.service.ProductService;
//import com.zp.basic.warehouse.biz.WarehouseBiz;
//import com.zp.basic.warehouse.model.ProductWarehouseRel;
//import com.zp.basic.warehouse.model.WareHouse;
//import com.zp.basic.warehouse.request.BindProductWarehouseRequest;
//import com.zp.basic.warehouse.request.ChangeProductWarehouseBindRelRequest;
//import com.zp.basic.warehouse.request.SelectPageWarehouseRequest;
//import com.zp.basic.warehouse.request.UpdateProductWarehouseStockRequest;
//import com.zp.basic.warehouse.service.ProductWarehouseRelService;
//import com.zp.basic.warehouse.service.WarehouseService;
//import com.zp.basic.warehouse.vo.SelectPageWarehouseVo;
//import com.zp.util.general.enums.StatusEnum;
//import com.zp.util.general.enums.SysCodeEnum;
//import com.zp.util.general.response.CommonResponse;
//import com.zp.util.general.util.BeanUtil;
//import com.zp.util.general.util.DateUtils;
//import com.zp.util.general.util.JedisUtil;
//import com.zp.util.general.util.MyBigDecimalUtil;
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * @author zp
// * @create 2022/2/5 15:38
// * @desc 仓库管理核心业务实现层
// **/
//@Service
//public class WarehouseBizImpl implements WarehouseBiz {
//    private WarehouseService warehouseService;
//    private ProductService productService;
//    private ProductWarehouseRelService productWarehouseRelService;
//
//    public WarehouseBizImpl(WarehouseService warehouseService, ProductService productService, ProductWarehouseRelService productWarehouseRelService) {
//        this.warehouseService = warehouseService;
//        this.productService = productService;
//        this.productWarehouseRelService = productWarehouseRelService;
//    }
//
//    @Override
//    public Map<String, Object> selectPageWarehouse(SelectPageWarehouseRequest selectPageWarehouseRequest) {
//        //加工请求体
//        IPage<SelectPageWarehouseVo> warehousePage = new Page<>(selectPageWarehouseRequest.getPageIndex(), selectPageWarehouseRequest.getPageSize());
//        IPage<SelectPageWarehouseVo> wareHouseIPage = warehouseService.selectPageWarehouse(warehousePage, selectPageWarehouseRequest.getWarehouseCode(), selectPageWarehouseRequest.getProductId());
//        return CommonResponse.setResponseData(wareHouseIPage);
//    }
//
//    @Override
//    public Map<String, Object> selectPageBindWarehouse(SelectPageWarehouseRequest selectPageWarehouseRequest) {
//        //加工请求体
//        IPage<SelectPageWarehouseVo> warehousePage = new Page<>(selectPageWarehouseRequest.getPageIndex(), selectPageWarehouseRequest.getPageSize());
//        IPage<SelectPageWarehouseVo> wareHouseIPage = warehouseService.selectPageBindWarehouse(warehousePage, selectPageWarehouseRequest.getWarehouseCode(), selectPageWarehouseRequest.getProductId());
//        return CommonResponse.setResponseData(wareHouseIPage);
//    }
//
//    @Override
//    public Map<String, Object> bindProductWarehouse(BindProductWarehouseRequest bindProductWarehouseRequest) {
//        ProductWarehouseRel productWarehouseRel = BeanUtil.convert(bindProductWarehouseRequest, ProductWarehouseRel.class);
//        String nowTime = DateUtils.getNowTime();
//        Date date = DateUtils.dateReturnFormat(nowTime);
//        //库存数初始为0，启用状态初始为启用
//        productWarehouseRel.setStatus(StatusEnum.YES.getFlag());
//        productWarehouseRel.setCreateTime(date);
//        productWarehouseRelService.saveProductWarehouseRel(productWarehouseRel);
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> updateProductWarehouseStock(UpdateProductWarehouseStockRequest updateProductWarehouseStockRequest) {
//        String productWarehouseId = updateProductWarehouseStockRequest.getProductWarehouseId();
//        BigDecimal stock = updateProductWarehouseStockRequest.getStock();
//        //判断关系是否存在
//        ProductWarehouseRel productWarehouseRel = productWarehouseRelService.findProductWarehouseRelById(productWarehouseId);
//        Assert.notNull(productWarehouseRel, "该关系不存在！");
//        productWarehouseRel.setStock(stock);
//        //更新数据库库存关系
//        productWarehouseRelService.updateProductWarehouseRel(productWarehouseRel);
//        //更新商品表库存
//        this.changeDbProductStock(productWarehouseRel.getProductId());
//        //更新ES\REDIS
//        Product product = productService.findProductById(productWarehouseRel.getProductId());
//        this.saveProductToRedisAndEs(product);
//        return CommonResponse.setResponseData(null);
//    }
//
//    @Override
//    @Transactional
//    public Map<String, Object> changeProductWarehouseBindRel(ChangeProductWarehouseBindRelRequest changeProductWarehouseBindRelRequest) {
//        String productWarehouseId = changeProductWarehouseBindRelRequest.getProductWarehouseId();
//        String status = changeProductWarehouseBindRelRequest.getStatus();
//        ProductWarehouseRel productWarehouseRelById = productWarehouseRelService.findProductWarehouseRelById(productWarehouseId);
//        productWarehouseRelById.setStatus(status);
//        productWarehouseRelService.updateProductWarehouseRel(productWarehouseRelById);
//        //更新商品表库存
//        this.changeDbProductStock(productWarehouseRelById.getProductId());
//        //更新ES\REDIS
//        Product product = productService.findProductById(productWarehouseRelById.getProductId());
//        this.saveProductToRedisAndEs(product);
//        return CommonResponse.setResponseData(null);
//    }
//
//    private void changeDbProductStock(String productId) {
//        BigDecimal bigDecimal = new BigDecimal("0");
//        //计算商品总库存
//        List<String> id = new ArrayList<>();
//        id.add(productId);
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(id);
//        if(CollectionUtils.isNotEmpty(productStockDtoList)){
//            bigDecimal=productStockDtoList.get(0).getStock();
//        }
//        //更新数据库库存
//        productService.updateProductStockById(productId,bigDecimal);
//    }
//
//    private void saveProductToRedisAndEs(Product product) {
//        //计算库存
//        this.handleProductStock(product);
//        //计算索引的库存和金额
//        ProductIndex productIndex=this.handleIndexProductStockAndMoney(product);
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
//        ProductIndex productIndex = BeanUtil.convert(product, ProductIndex.class,Product.STOCK,Product.PRODUCT_MONEY);
//        productIndex.setStock(stock);
//        productIndex.setProductMoney(money);
//        return productIndex;
//    }
//
//    private void handleProductStock(Product product) {
//        List<String> id = new ArrayList<>();
//        id.add(product.getProductId());
//        List<ProductStockDto> productStockDtoList = warehouseService.selectStock(id);
//        if(CollectionUtils.isNotEmpty(productStockDtoList)){
//            ProductStockDto productStockDto = productStockDtoList.get(0);
//            product.setStock(productStockDto.getStock());
//        }
//    }
//}
