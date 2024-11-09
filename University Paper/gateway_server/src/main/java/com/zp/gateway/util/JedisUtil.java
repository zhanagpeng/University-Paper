package com.zp.gateway.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author zp
 * @create 2021/7/25 18:30
 * @desc jedis工具类
 **/
public class JedisUtil {
    private static JedisPool jedisPool = null;
    private static String host = null;
    private static int port;
    private static int maxToal;
    private static int maxIdel;
    /**
     * 密码
     */
    private static String passWord;
    /**
     * 超时时间
     */
    private static Integer timeOut;

    //初始化
    static {
        ResourceBundle redis = ResourceBundle.getBundle("redis");
        host = redis.getString("spring.redis.host");
        port = Integer.parseInt(redis.getString("spring.redis.port"));
        maxToal = Integer.parseInt(redis.getString("spring.redis.maxToal"));
        maxIdel = Integer.parseInt(redis.getString("spring.redis.maxIdel"));
        passWord = redis.getString("spring.redis.password");
        timeOut= Integer.valueOf(redis.getString("spring.redis.timeout"));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdel);
        jedisPoolConfig.setMaxTotal(maxToal);
        jedisPool = new JedisPool(jedisPoolConfig, host, port,timeOut,passWord);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
