package com.zp.auth.user.request;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2021/12/21 20:45

 * @desc    用户request

 **/
public class UserRequest {
    /**
     * 用户ID
     */
    private String uId;
    /**
     * 用户名称
     */
    @NotBlank(message = "uName不能为空")
    private String uName;
    /**
     * 用户密码
     */
    @NotBlank(message = "password不能为空")
    private String password;
    /**
     * 角色ID
     */
    @NotBlank(message = "rId不能为空")
    private String rId;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 0:正常 1:注销
     */
    private String status;


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

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

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
