package com.zp.auth.user.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2021/12/18 16:16

 * @desc    登录校验Request

 **/
@Data
public class LoginRequest {
    @NotBlank(message = "uName不能为空")
    private String uName;
    @NotBlank(message = "password不能为空")
    private String password;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
