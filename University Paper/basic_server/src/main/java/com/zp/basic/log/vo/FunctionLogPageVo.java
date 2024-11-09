package com.zp.basic.log.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**

 * @author  zp

 * @create  2022/1/16 17:54

 * @desc    功能日志分页VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionLogPageVo {
    private String id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 用户id
     */
    private String createUserName;
    /**
     * 事件
     */
    private String action;
}
