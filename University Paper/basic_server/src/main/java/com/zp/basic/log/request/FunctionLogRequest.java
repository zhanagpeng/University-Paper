package com.zp.basic.log.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**

 * @author  zp

 * @create  2022/1/16 17:37

 * @desc    功能日志分页查询请求类

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionLogRequest {
    //用户名称
    private String name;
    //时间
    private List<String> date;
    //事件
    private String action;
    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;
    //当前页
    private Integer pageIndex;
    //分页数
    private Integer pageSize;
}
