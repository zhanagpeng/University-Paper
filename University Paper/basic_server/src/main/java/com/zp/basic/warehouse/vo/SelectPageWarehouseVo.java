package com.zp.basic.warehouse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**

 * @author  zp

 * @create  2022/2/5 18:59

 * @desc    商品未绑定仓库编码

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPageWarehouseVo {
    /**
     * 状态 0：停用；1：启用
     */
    private String  status;
    /**
     * 商品仓库绑定关系主键
     */
    private String productWarehouseId;
    /**
     * 商品主键
     */
    private String productId;
    /**
     * 仓库主键
     */
    private String warehouseId;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库号（区分库存）
     */
    private String warehouseCode;
    /**
     * 库存
     */
    private BigDecimal stock;
}
