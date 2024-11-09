package com.zp.auth.role.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2021/12/27 20:44

 * @desc    新增角色request

 **/
@Data
public class RoleAddRequest {

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
