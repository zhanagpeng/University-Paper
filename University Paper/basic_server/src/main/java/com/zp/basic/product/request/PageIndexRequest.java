package com.zp.basic.product.request;

import lombok.Data;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**

 * @author  zp

 * @create  2022/1/28 17:34

 * @desc    索引分页泛型

 **/
@Data
public abstract class PageIndexRequest {

    /**
     * 分页大小
     */
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    /**
     * 页码
     */
    @NotNull(message = "pageIndex不能为空")
    private Integer pageIndex;



}