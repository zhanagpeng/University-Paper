package com.zp.basic.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.basic.product.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zp
 * @create 2022/1/30 15:12
 * @desc 商品持久层
 **/
@Repository
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 批量修改商品状态
     * @param productIds
     * @param flagValue
     */
    void batchUpdateProductStatus(@Param("productIds") List<String> productIds,@Param("flagValue") String flagValue);

    /**
     * 根据商品ID更新库存
     * @param productId
     * @param stock
     */
    void updateProductStockById(@Param("productId") String productId,@Param("stock") BigDecimal stock);
}
