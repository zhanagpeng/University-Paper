package com.zp.basic.warehouse.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.log.vo.FunctionLogPageVo;
import com.zp.basic.product.dto.ProductStockDto;
import com.zp.basic.warehouse.model.ProductWarehouseRel;
import com.zp.basic.warehouse.model.WareHouse;
import com.zp.basic.warehouse.vo.SelectPageWarehouseVo;

import java.math.BigDecimal;
import java.util.List;

/**

 * @author  zp

 * @create  2022/2/5 15:39

 * @desc    仓库管理通用业务实现层

 **/
public interface WarehouseService {
    /**
     * 分页查询商品未绑定仓库
     * @param warehousePage
     * @param warehouseCode
     * @param productId
     * @return
     */
    IPage<SelectPageWarehouseVo> selectPageWarehouse(IPage<SelectPageWarehouseVo> warehousePage, String warehouseCode, String productId);

    /**
     * 分页查询商品已绑定仓库
     * @param warehousePage
     * @param warehouseCode
     * @param productId
     * @return
     */
    IPage<SelectPageWarehouseVo> selectPageBindWarehouse(IPage<SelectPageWarehouseVo> warehousePage, String warehouseCode, String productId);

    /**
     * 根据商品ID计算库存总量
     * @param productIds
     * @return
     */
    List<ProductStockDto> selectStock(List<String> productIds);

    /**
     * 根据仓库编码查询商品库存
     * @param productId
     * @param code
     * @return
     */
    BigDecimal findSockByProductIdAndWarehouseCode(String productId, String code);

    /**
     * 根据仓库编码、商品ID扣减库存
     * @param productId
     * @param warehouseId
     * @param num
     */
    void deductingTheStockByProductIdAndWarehouseId(String productId, String warehouseId, BigDecimal num);
}
