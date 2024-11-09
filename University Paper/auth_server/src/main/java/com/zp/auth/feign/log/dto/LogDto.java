package com.zp.auth.feign.log.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author zp
 * @create 2022/1/17 20:14
 * @desc 日志DTO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 用户id
     */
    @NotBlank(message = "createUser不能为空")
    private String createUser;
    /**
     * 事件
     */
    @NotBlank(message = "action不能为空")
    private String action;
}
