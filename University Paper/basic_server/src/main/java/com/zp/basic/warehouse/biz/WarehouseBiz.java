package com.zp.basic.warehouse.biz;

import com.zp.basic.warehouse.request.BindProductWarehouseRequest;
import com.zp.basic.warehouse.request.ChangeProductWarehouseBindRelRequest;
import com.zp.basic.warehouse.request.SelectPageWarehouseRequest;
import com.zp.basic.warehouse.request.UpdateProductWarehouseStockRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Map;

/**

 * @author  zp

 * @create  2022/2/5 15:30

 * @desc    仓库管理核心业务层

 **/
@Validated
public interface WarehouseBiz {
    /**
     * 分页查询商品未绑定仓库
     * @param selectPageWarehouseRequest
     * @return
     */
    Map<String, Object> selectPageWarehouse(@Valid SelectPageWarehouseRequest selectPageWarehouseRequest);

    /**
     * 分页查询商品绑定仓库
     * @param selectPageWarehouseRequest
     * @return
     */
    Map<String, Object> selectPageBindWarehouse(@Valid SelectPageWarehouseRequest selectPageWarehouseRequest);

    /**
     * 商品绑定仓库
     * @param bindProductWarehouseRequest
     * @return
     */
    Map<String, Object> bindProductWarehouse(@Valid BindProductWarehouseRequest bindProductWarehouseRequest);

    /**
     * 编辑商品仓库库存
     * @param updateProductWarehouseStockRequest
     * @return
     */
    Map<String, Object> updateProductWarehouseStock(@Valid UpdateProductWarehouseStockRequest updateProductWarehouseStockRequest);

    /**
     * 商品仓库绑定关系停启用
     * @param changeProductWarehouseBindRelRequest
     * @return
     */
    Map<String, Object> changeProductWarehouseBindRel(@Valid ChangeProductWarehouseBindRelRequest changeProductWarehouseBindRelRequest);
}
