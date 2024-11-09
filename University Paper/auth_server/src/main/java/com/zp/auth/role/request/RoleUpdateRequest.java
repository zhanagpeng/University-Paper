package com.zp.auth.role.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zp
 * @create 2021/12/27 21:31
 * @desc 更新角色Request
 **/
@Data
public class RoleUpdateRequest {
    /**
     * 角色ID
     */
    @NotBlank(message = "rId不能为空")
    private String rId;
    /**
     * 角色名称
     */
    @NotBlank(message = "rName不能为空")
    private String rName;
    /**
     * 角色描述
     */
    @NotBlank(message = "rDesc不能为空")
    private String rDesc;



}
