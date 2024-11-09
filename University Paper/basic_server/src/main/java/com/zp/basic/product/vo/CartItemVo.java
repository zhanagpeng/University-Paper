package com.zp.basic.product.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**

 * @author  zp

 * @create  2022/2/12 16:24

 * @desc    购物车项VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemVo {
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
    private BigDecimal productMoney;
    /**
     * 库存总数
     */
    private BigDecimal stock;
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
    private Date createTime;
    /**
     * 购买数量
     */
    private Integer num;
}
