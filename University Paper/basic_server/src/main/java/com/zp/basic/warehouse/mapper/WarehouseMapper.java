package com.zp.basic.warehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.product.dto.ProductStockDto;
import com.zp.basic.warehouse.model.ProductWarehouseRel;
import com.zp.basic.warehouse.model.WareHouse;
import com.zp.basic.warehouse.vo.SelectPageWarehouseVo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zp
 * @create 2022/2/5 15:53
 * @desc 仓库持久层
 **/
@Repository
public interface WarehouseMapper extends BaseMapper<WareHouse> {
    /**
     * 分页查询仓库
     *
     * @param warehousePage
     * @param warehouseCode
     * @return
     */
    IPage<SelectPageWarehouseVo> selectPageWarehouse(@Param("warehousePage") IPage<SelectPageWarehouseVo> warehousePage, @Param("warehouseCode") String warehouseCode, @Param("productId") String productId);

    /**
     * 分页查询商品已绑定仓库
     *
     * @param warehousePage
     * @param warehouseCode
     * @param productId
     * @return
     */
    IPage<SelectPageWarehouseVo> selectPageBindWarehouse(IPage<SelectPageWarehouseVo> warehousePage, String warehouseCode, String productId);

    /**
     * 根据商品ID计算库存总量
     *
     * @param productIds
     * @return
     */
    List<ProductStockDto> selectStock(List<String> productIds);


    /**
     * 根据仓库编码查询商品库存
     *
     * @param productId
     * @param code
     * @return
     */
    BigDecimal findSockByProductIdAndWarehouseCode(@Param("productId") String productId, @Param("code") String code);

    /**
     * 根据仓库编码、商品ID扣减库存
     * @param productId
     * @param warehouseId
     * @param num
     */
    void deductingTheStockByProductIdAndWarehouseId(@Param("productId") String productId,@Param("warehouseId") String warehouseId,@Param("num") BigDecimal num);
}
