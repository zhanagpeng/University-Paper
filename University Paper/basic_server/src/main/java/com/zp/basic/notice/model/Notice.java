package com.zp.basic.notice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;

import java.io.Serializable;

/**

 * @author  zp

 * @create  2022/1/19 12:16

 * @desc    消息实体类

 **/
@TableName(value = "t_notice")
public class Notice extends BaseEntity {
    private static final long serialVersionUID = 3287659263037483763L;

    public static final String N_ID="n_id";
    public static final String SEND_MAN="send_man";
    public static final String RECEIVE_MAN="receive_man";
    public static final String E_ID="e_id";
    public static final String HAVE_READ="have_read";

    @TableId(type = IdType.UUID)
    private String nId;
    /**
     * 发送人id
     */
    private String sendMan;
    /**
     * 收件人id
     */
    private String receiveMan;
    /**
     * 信件id
     */
    private String eId;
    /**
     * 是否已读（0未读，1已读）
     */
    private String haveRead;


    public Notice() {
    }



    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String getSendMan() {
        return sendMan;
    }

    public void setSendMan(String sendMan) {
        this.sendMan = sendMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getHaveRead() {
        return haveRead;
    }

    public void setHaveRead(String haveRead) {
        this.haveRead = haveRead;
    }

}
