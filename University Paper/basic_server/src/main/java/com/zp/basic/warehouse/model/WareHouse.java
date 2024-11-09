package com.zp.basic.warehouse.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;

import java.io.Serializable;

/**

 * @author  zp

 * @create  2022/2/5 15:47

 * @desc    仓库实体类

 **/
@TableName("t_warehouse")
public class WareHouse extends BaseEntity {
    private static final long serialVersionUID = 1713153682800517943L;
    public  static final String WAREHOUSE_ID="warehouse_id";
    public  static final String WAREHOUSE_NAME="warehouse_name";
    public  static final String WAREHOUSE_CODE="warehouse_code";

    @TableId(type = IdType.UUID)
    private String warehouseId;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库号（区分库存）
     */
    private String warehouseCode;

    public WareHouse() {
    }

    public WareHouse(String warehouseId, String warehouseName, String warehouseCode) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}
