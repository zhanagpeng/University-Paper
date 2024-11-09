package com.zp.basic.notice.vo;

/**
 * @author zp
 * @create 2022/1/19 22:00
 * @desc 站内信分页VO
 **/
public class NoticePageVo {
    /**
     * 消息ID
     */
    private String nId;
    /**
     * 发件人
     */
    private String uName;
    /**
     * 信件ID
     */
    private String eId;
    /**
     * 信件主题
     */
    private String eTopic;
    /**
     * 发送时间
     */
    private String createTime;
    /**
     * 是否已读
     */
    private String haveRead;

    public NoticePageVo() {
    }

    public NoticePageVo(String nId, String uName, String eId, String eTopic, String createTime, String haveRead) {
        this.nId = nId;
        this.uName = uName;
        this.eId = eId;
        this.eTopic = eTopic;
        this.createTime = createTime;
        this.haveRead = haveRead;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteTopic() {
        return eTopic;
    }

    public void seteTopic(String eTopic) {
        this.eTopic = eTopic;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHaveRead() {
        return haveRead;
    }

    public void setHaveRead(String haveRead) {
        this.haveRead = haveRead;
    }
}
