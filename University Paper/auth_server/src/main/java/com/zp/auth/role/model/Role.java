package com.zp.auth.role.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp.util.general.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zp
 * @create 2021/12/23 21:46
 * @desc 角色实体类
 **/
@Data
@ToString
@TableName(value = "t_role")
public class Role extends BaseEntity {
    private static final long serialVersionUID = -1388580148376174233L;
    @TableId(type = IdType.UUID)
    private String rId;
    /**
     * 角色名称
     */
    private String rName;
    /**
     * 角色描述
     */
    private String rDesc;

}
