package com.zp.auth.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 * @author  zp

 * @create  2021/12/19 19:03

 * @desc    用户查询VO

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageRequest {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户角色
     */
    private String roleId;
    /**
     * 分页号
     */
    private Integer pageIndex;
    /**
     * 分页大小
     */
    private Integer pageSize;
}
