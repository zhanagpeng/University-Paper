package com.zp.basic.warehouse.service.impl;

import com.zp.basic.warehouse.mapper.ProductWarehouseRelMapper;
import com.zp.basic.warehouse.model.ProductWarehouseRel;
import com.zp.basic.warehouse.service.ProductWarehouseRelService;
import org.springframework.stereotype.Service;

/**
 * @author zp
 * @create 2022/2/6 15:23
 * @desc 商品仓库绑定关系通用业务实现层
 **/
@Service
public class ProductWarehouseRelServiceImpl implements ProductWarehouseRelService {
    private ProductWarehouseRelMapper productWarehouseRelMapper;

    public ProductWarehouseRelServiceImpl(ProductWarehouseRelMapper productWarehouseRelMapper) {
        this.productWarehouseRelMapper = productWarehouseRelMapper;
    }

    @Override
    public void saveProductWarehouseRel(ProductWarehouseRel productWarehouseRel) {
        productWarehouseRelMapper.insert(productWarehouseRel);
    }

    @Override
    public ProductWarehouseRel findProductWarehouseRelById(String productWarehouseId) {
        return productWarehouseRelMapper.selectById(productWarehouseId);
    }

    @Override
    public void updateProductWarehouseRel(ProductWarehouseRel productWarehouseRel) {
        productWarehouseRelMapper.updateById(productWarehouseRel);
    }
}
