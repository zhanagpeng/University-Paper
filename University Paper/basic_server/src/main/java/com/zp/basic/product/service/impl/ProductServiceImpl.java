package com.zp.basic.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zp.basic.product.mapper.ProductMapper;
import com.zp.basic.product.model.Product;
import com.zp.basic.product.request.ProductSaveRequest;
import com.zp.basic.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author zp
 * @create 2022/1/28 15:43
 * @desc 商品通用业务实现层
 **/
@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product findProductByProductCodeAndBatch(ProductSaveRequest productRequest) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Product.PRODUCT_CODE, productRequest.getProductCode());
        return productMapper.selectOne(queryWrapper);
    }

    @Override
    public void saveProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public Product findProductById(String productId) {
        return productMapper.selectById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateById(product);
    }

    @Override
    public List<Product> selectProductByIds(List<String> ids) {
        return productMapper.selectBatchIds(ids);
    }

    @Override
    public void batchUpdateProductStatus(List<String> productIds, String flagValue) {
        productMapper.batchUpdateProductStatus(productIds,flagValue);
    }

    @Override
    public Product findProductByCode(String productCode) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Product.PRODUCT_CODE,productCode);
        return productMapper.selectOne(queryWrapper);
    }

    @Override
    public void updateProductStockById(String productId, BigDecimal stock) {
        productMapper.updateProductStockById(productId,stock);
    }


}
