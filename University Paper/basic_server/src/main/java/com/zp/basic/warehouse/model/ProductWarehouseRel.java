package com.zp.basic.warehouse.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**

 * @author  zp

 * @create  2022/2/6 15:15

 * @desc    商品仓库关系表

 **/
@TableName(value = "product_warehouse_rel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWarehouseRel extends BaseEntity {

    private static final long serialVersionUID = -1382297959027051238L;
    public static final String PRODUCT_WAREHOUSE_UD="productWarehouseId";
    public static final String PRODUCT_ID="productId";
    public static final String WAREHOUSE_ID="warehouseId";
    public static final String STOCK="stock";
    public static final String STATUS="status";

    @TableId(type = IdType.UUID)
    private String productWarehouseId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 仓库id（区分库存）
     */
    private String warehouseId;
    /**
     * 库存数
     */
    private BigDecimal stock;
    /**
     * 0禁用，1启用
     */
    private String status;

}
