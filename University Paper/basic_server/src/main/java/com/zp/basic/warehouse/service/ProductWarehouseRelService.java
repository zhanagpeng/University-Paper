package com.zp.basic.warehouse.service;

import com.zp.basic.warehouse.model.ProductWarehouseRel;

/**

 * @author  zp

 * @create  2022/2/6 15:22

 * @desc    商品仓库绑定关系通用业务层

 **/
public interface ProductWarehouseRelService {
    /**
     * 保存商品仓库绑定关系
     * @param productWarehouseRel
     */
    void saveProductWarehouseRel(ProductWarehouseRel productWarehouseRel);

    /**
     * 根据ID查询绑定关系
     * @param productWarehouseId
     */
    ProductWarehouseRel findProductWarehouseRelById(String productWarehouseId);

    /**
     * 更新商品仓库绑定关系
     * @param productWarehouseRel
     */
    void updateProductWarehouseRel(ProductWarehouseRel productWarehouseRel);
}
