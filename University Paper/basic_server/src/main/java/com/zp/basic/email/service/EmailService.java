package com.zp.basic.email.service;

import com.zp.basic.email.model.Email;

import java.util.List;

/**

 * @author  zp

 * @create  2022/1/22 15:03

 * @desc    信件通用业务层

 **/
public interface EmailService {
    /**
     * 保存信件
     * @param email
     */
    void saveEmail(Email email);

    /**
     * 根据eid删除信件
     * @param emailIds
     */
    void deleteByEmailIds(List<String> emailIds);

    /**
     * 根据eId查询信件
     * @param eId
     * @return
     */
    Email selectEmailByEmailId(String eId);
}
