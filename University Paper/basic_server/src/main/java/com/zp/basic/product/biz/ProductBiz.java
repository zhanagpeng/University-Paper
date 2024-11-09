package com.zp.basic.product.biz;

import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.zp.basic.product.model.Product;
import com.zp.basic.product.request.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**

 * @author  zp

 * @create  2022/1/28 15:40

 * @desc    商品核心业务层

 **/
@Validated
public interface ProductBiz {
    /**
     * 分页查询商品管理界面
     * @param selectPageProductRequest
     * @return
     */
    Map<String, Object> selectPageProduct(@Valid SelectPageProductRequest selectPageProductRequest) throws IOException;

    /**
     * 新增商品
     * @param productRequest
     * @return
     */
    Map<String, Object> insertProduct(@Valid ProductSaveRequest productRequest);

    /**
     * 更新商品
     * @param productUpdateRequest
     * @return
     */
    Map<String, Object> updateProduct(@Valid ProductUpdateRequest productUpdateRequest);

    /**
     * 批量更新商品上下架状态
     * @param updateProductStatusRequest
     * @return
     */
    Map<String, Object> updateProductStatus(@Valid UpdateProductStatusRequest updateProductStatusRequest);

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    Map<String, Object> findProductById(@NotBlank(message = "id不能为空") String id);

    /**
     * 分页查询商城商品
     * @param selectPageProductRequest
     * @return
     */
    Map<String, Object> selectPageProductShop(@Valid SelectPageProductRequest selectPageProductRequest);

    /**
     * 加入购物车
     * @param productId
     * @return
     */
    Map<String, Object> addCart(String productId);

    /**
     * 查看购物车
     * @param productCodeOrName
     * @return
     */
    Map<String, Object> showCart(String productCodeOrName);

    /**
     * 保存商品至redis、es（消费者）手动确认
     * @param product
     */
    void saveProductToEsAndRedis(Product product);

    /**
     * 保存商品至redis、es（监听死信队列（TTL+死信队列=消息延迟））手动确认
     * @param productId
     */
    void saveTtlProductToEsAndRedis(String productId);

    /**
     * 根据商品购物车项删除
     * @param productIds
     * @return
     */
    Map<String, Object> deleteCartItem(@NotEmpty(message = "productIds不能为空") List<String> productIds);

    /**
     * 清空购物车
     * @return
     */
    Map<String, Object> deleteAllCartItem();

    /**
     *
     * @param changeCartItemNumRequest
     * @return
     */
    Map<String, Object> changeCartItemNum(ChangeCartItemNumRequest changeCartItemNumRequest);
}
