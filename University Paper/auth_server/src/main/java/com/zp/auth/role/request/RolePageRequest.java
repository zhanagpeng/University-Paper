package com.zp.auth.role.request;

import lombok.Data;

/**

 * @author  zp

 * @create  2021/12/27 0:01

 * @desc    动态查询角色Request

 **/
@Data
public class RolePageRequest {
    /**
     * 角色名称
     */
    private String rName;
    /**
     * 创建日期
     */
    private String cDate;
    /**
     * 分页当前页数
     */
    private Integer pageIndex;
    /**
     * 分页每页数量
     */
    private Integer pageSize;
}
