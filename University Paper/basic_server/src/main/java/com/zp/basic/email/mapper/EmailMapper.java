package com.zp.basic.email.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.basic.email.model.Email;
import org.springframework.stereotype.Repository;

/**

 * @author  zp

 * @create  2022/1/22 15:05

 * @desc    信件持久层

 **/
@Repository
public interface EmailMapper extends BaseMapper<Email> {

}
