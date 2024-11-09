//package com.zp.basic.warehouse.controller;
//
//import com.zp.basic.warehouse.biz.WarehouseBiz;
//import com.zp.basic.warehouse.request.BindProductWarehouseRequest;
//import com.zp.basic.warehouse.request.ChangeProductWarehouseBindRelRequest;
//import com.zp.basic.warehouse.request.SelectPageWarehouseRequest;
//import com.zp.basic.warehouse.request.UpdateProductWarehouseStockRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
///**
// * @author zp
// * @create 2022/2/5 15:14
// * @desc 仓库管理控制层
// **/
//@RestController
//@RequestMapping("/warehouseController")
//public class WarehouseController {
//    private WarehouseBiz warehouseBiz;
//
//    public WarehouseController(WarehouseBiz warehouseBiz) {
//        this.warehouseBiz = warehouseBiz;
//    }
//
//    /**
//     * 分页查询商品未绑定仓库
//     * @param selectPageWarehouseRequest
//     * @return
//     */
//    @PostMapping(value = "/selectPageWarehouse.json")
//    public Map<String, Object> selectPageWarehouse(@RequestBody SelectPageWarehouseRequest selectPageWarehouseRequest) {
//        return warehouseBiz.selectPageWarehouse(selectPageWarehouseRequest);
//    }
//    /**
//     * 分页查询商品已绑定仓库
//     * @param selectPageWarehouseRequest
//     * @return
//     */
//    @PostMapping(value = "/selectPageBindWarehouse.json")
//    public Map<String, Object> selectPageBindWarehouse(@RequestBody SelectPageWarehouseRequest selectPageWarehouseRequest) {
//        return warehouseBiz.selectPageBindWarehouse(selectPageWarehouseRequest);
//    }
//
//    /**
//     * 商品绑定仓库
//     * @param bindProductWarehouseRequest
//     * @return
//     */
//    @PostMapping(value = "/bindProductWarehouse.json")
//    public Map<String,Object> bindProductWarehouse(@RequestBody BindProductWarehouseRequest bindProductWarehouseRequest){
//        return warehouseBiz.bindProductWarehouse(bindProductWarehouseRequest);
//    }
//
//    /**
//     * 商品仓库绑定关系停启用
//     * @param changeProductWarehouseBindRelRequest
//     * @return
//     */
//    @PostMapping(value = "/changeProductWarehouseBindRel.json")
//    public Map<String,Object> changeProductWarehouseBindRel(@RequestBody ChangeProductWarehouseBindRelRequest changeProductWarehouseBindRelRequest){
//        return warehouseBiz.changeProductWarehouseBindRel(changeProductWarehouseBindRelRequest);
//    }
//
//    /**
//     * 编辑商品仓库库存
//     * @param updateProductWarehouseStockRequest
//     * @return
//     */
//    @PostMapping(value = "/updateProductWarehouse.json")
//    public Map<String,Object> updateProductWarehouseStock(@RequestBody UpdateProductWarehouseStockRequest updateProductWarehouseStockRequest){
//        return warehouseBiz.updateProductWarehouseStock(updateProductWarehouseStockRequest);
//    }
//
//}
