package com.zp.basic.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zp
 * @create 2022/1/28 15:47
 * @desc 商品管理分页查询请求类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPageProductRequest extends PageIndexRequest {
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 有无库存，0：无，1：有
     */
    private String haveStock;
    /**
     * 是否启用0禁用，1启用
     */
    private String status;


}
