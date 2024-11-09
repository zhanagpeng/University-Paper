package com.zp.basic.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zp.util.general.enums.SysCodeEnum;
import com.zp.util.general.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @authoer:zp
 * @createDate:2021/7/18
 * @description:自动填充
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATE_USER = "createUser";
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_USER = "updateUser";
    private static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        String token = this.getRequestToken();
        if (StringUtils.isNotBlank(token)) {
            String userId;
            try (Jedis jedis = JedisUtil.getJedis()) {
                userId = jedis.get(token);
            }
            if (metaObject.hasSetter(CREATE_USER)) {
                this.setFieldValByName(CREATE_USER, userId, metaObject);
            }
        }
        if (metaObject.hasSetter(CREATE_TIME)) {
            this.setFieldValByName(CREATE_TIME, new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String token = this.getRequestToken();
        if (StringUtils.isNotBlank(token)) {
            String userId;
            try (Jedis jedis = JedisUtil.getJedis()) {
                userId = jedis.get(token);
            }
            if (metaObject.hasSetter(UPDATE_USER)) {
                this.setFieldValByName(UPDATE_USER, userId, metaObject);
            }
        }
        if (metaObject.hasSetter(UPDATE_TIME)) {
            this.setFieldValByName(UPDATE_TIME, new Date(), metaObject);
        }
    }

    private String getRequestToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        return token;
    }
}