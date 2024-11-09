package com.zp.basic.notice.request;

import javax.validation.constraints.NotBlank;

/**

 * @author  zp

 * @create  2022/1/23 19:09

 * @desc    查看信件请求类

 **/
public class CheckTheNoticeRequest {
    /**
     * 消息ID
     */
    @NotBlank(message = "nId不能为空")
    private String nId;
    /**
     * 信件ID
     */
    @NotBlank(message = "eId不能为空")
    private String eId;

    public CheckTheNoticeRequest() {
    }

    public CheckTheNoticeRequest(String nId, String eId) {
        this.nId = nId;
        this.eId = eId;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }
}
