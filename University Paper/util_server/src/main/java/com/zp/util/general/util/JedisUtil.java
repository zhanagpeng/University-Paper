package com.zp.util.general.util;

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
     * 购物车key
     */
    public static final String CART_KEY="cart:usersId:%s";
    /**
     * 商品详情key
     */
    public static final String PRODUCT_KEY="productInfo:productId:%s";
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
        jedisPoolConfig.setMaxWaitMillis(timeOut);
        jedisPool = new JedisPool(jedisPoolConfig, host, port,timeOut,passWord);
    }

    /**
     * 获取JEDIS客户端
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭jedis客户端
     * @param jedis
     */
    public static void close(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }

    /**
     * 构建购物车key
     * @param format
     * @param args
     * @return
     */
    public static String buildKey(String format,Object... args){
      return   String.format(format, args);
    }


}
