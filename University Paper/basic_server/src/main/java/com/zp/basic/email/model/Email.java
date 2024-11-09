package com.zp.basic.email.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author zp
 * @create 2022/1/22 14:44
 * @desc 信件实体类
 **/
@TableName(value = "t_email")
public class Email extends BaseEntity {
    private static final long serialVersionUID = -1388580148346274233L;

    private static final String E_ID="e_id";
    private static final String E_TOPIC="e_topic";
    private static final String FILE_JSON="file_json";
    private static final String E_CONTENT="e_content";
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String eId;
    /**
     * 标题
     */
    private String eTopic;
    /**
     * 附件存放下载地址
     */
    private String fileJson;
    /**
     * 内容
     */
    private String eContent;


    public Email() {
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

    public String getFileJson() {
        return fileJson;
    }

    public void setFileJson(String fileJson) {
        this.fileJson = fileJson;
    }

    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent;
    }


}
