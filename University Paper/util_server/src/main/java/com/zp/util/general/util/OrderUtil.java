package com.zp.util.general.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**

 * @author  zp

 * @create  2022/2/25 21:50

 * @desc    订单工具类

 **/
public class OrderUtil {
    //订单编号前缀
    private static final String ORDER_NUM_PREFIX="XS";

    /**
     * 生成订单编号
     * @return
     */
    public static String generateOrderNumber(){
        String uuid = UUID.randomUUID().toString();
        return ORDER_NUM_PREFIX+uuid;
    }
}
