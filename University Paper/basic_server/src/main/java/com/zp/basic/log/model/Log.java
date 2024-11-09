package com.zp.basic.log.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;

import java.io.Serializable;

/**

 * @author  zp

 * @create  2022/1/16 17:11

 * @desc    日志实体类

 **/
@TableName(value = "log_info")
public class Log extends BaseEntity {

    private static final long serialVersionUID = 5925249302222961923L;
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 事件
     */
    private String action;

    public Log() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
