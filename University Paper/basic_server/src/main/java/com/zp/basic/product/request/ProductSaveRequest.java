package com.zp.basic.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**

 * @author  zp

 * @create  2022/1/30 10:41

 * @desc    新增商品请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {
    /**
     * 商品编码
     */
    @NotBlank(message = "productCode不能为空")
    private String productCode;
    /**
     * 商品名称
     */
    @NotBlank(message = "productName不能为空")
    private String productName;
    /**
     * 商品价格（元）
     */
    @NotNull(message = "productMoney不能为空")
    private BigDecimal productMoney;
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
    @NotBlank(message = "status不能为空")
    private String status;
}
