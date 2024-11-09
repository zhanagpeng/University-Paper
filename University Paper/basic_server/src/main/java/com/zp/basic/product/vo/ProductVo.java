package com.zp.basic.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**

 * @author  zp

 * @create  2022/1/30 11:05

 * @desc    商品管理界面VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo {
    /**
     * 商品主键
     */
    private String productId;
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格（元）
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productMoney;
    /**
     * 库存数
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stock;
    /**
     * 真实商品价格（元）
     */
    private BigDecimal realProductMoney;
    /**
     * 真实库存数
     */
    private BigDecimal realStock;
    /**
     * 仓库号（区分库存）
     */
    private String warehouseCode;
    /**
     * 单位
     */
    private String speck;
    /**
     * 商品图片链接
     */
    private String productUrl;
    /**
     * 是否启用0禁用，1启用
     */
    private String status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
