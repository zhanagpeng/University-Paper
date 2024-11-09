package com.zp.util.general.util;

import org.springframework.util.DigestUtils;


/**
 * @author zp
 * @create 2021/7/28 10:45
 * @desc 生成token工具类
 **/
public class TokenUtil {
    //token过期时间
    public static final int INIT_TIME = 30*60 * 1000;

    //动态参数 传username+userid
    public static String generate(String... strings) {
        long timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s : strings) {
            tokenMeta = tokenMeta + s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }
}

