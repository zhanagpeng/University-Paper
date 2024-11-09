package com.zp.basic.warehouse.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.product.dto.ProductStockDto;
import com.zp.basic.warehouse.mapper.WarehouseMapper;
import com.zp.basic.warehouse.model.ProductWarehouseRel;
import com.zp.basic.warehouse.model.WareHouse;
import com.zp.basic.warehouse.service.WarehouseService;
import com.zp.basic.warehouse.vo.SelectPageWarehouseVo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zp
 * @create 2022/2/5 15:40
 * @desc 仓库管理通用业务实现层
 **/
@Service
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseMapper warehouseMapper;

    public WarehouseServiceImpl(WarehouseMapper warehouseMapper) {
        this.warehouseMapper = warehouseMapper;
    }

    @Override
    public IPage<SelectPageWarehouseVo> selectPageWarehouse(IPage<SelectPageWarehouseVo> warehousePage, String warehouseCode, String productId) {
        return warehouseMapper.selectPageWarehouse(warehousePage, warehouseCode, productId);
    }

    @Override
    public IPage<SelectPageWarehouseVo> selectPageBindWarehouse(IPage<SelectPageWarehouseVo> warehousePage, String warehouseCode, String productId) {
        return warehouseMapper.selectPageBindWarehouse(warehousePage, warehouseCode, productId);
    }

    @Override
    public List<ProductStockDto> selectStock(List<String> productIds) {
        return warehouseMapper.selectStock(productIds);
    }

    @Override
    public BigDecimal findSockByProductIdAndWarehouseCode(String productId, String code) {
        return warehouseMapper.findSockByProductIdAndWarehouseCode(productId, code);
    }

    @Override
    public void deductingTheStockByProductIdAndWarehouseId(String productId, String warehouseId, BigDecimal num) {
        warehouseMapper.deductingTheStockByProductIdAndWarehouseId(productId, warehouseId, num);
    }


}
