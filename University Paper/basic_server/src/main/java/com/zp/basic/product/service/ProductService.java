package com.zp.basic.product.service;

import com.zp.basic.product.model.Product;
import com.zp.basic.product.request.ProductSaveRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**

 * @author  zp

 * @create  2022/1/28 15:42

 * @desc    商品通用业务层

 **/
public interface ProductService {
    /**
     * 判断商品编码、批号是否存在
     * @param productRequest
     */
    Product findProductByProductCodeAndBatch(ProductSaveRequest productRequest);

    /**
     * 保存商品
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 判断商品是否存在
     * @param productId
     * @return
     */
    Product findProductById(String productId);

    /**
     * 更新商品
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 批量查询商品根据id
     * @param ids
     * @return
     */
    List<Product> selectProductByIds(List<String> ids);


    /**
     * 批量修改商品状态
     * @param productIds
     */
    void batchUpdateProductStatus(List<String> productIds, String flagValue);

    /**
     * 根据商品编码查询商品
     * @param productCode
     * @return
     */
    Product findProductByCode(String productCode);

    /**
     * 根据商品ID更新库存
     * @param productId
     * @param stock
     */
    void updateProductStockById(String productId, BigDecimal stock);
}
