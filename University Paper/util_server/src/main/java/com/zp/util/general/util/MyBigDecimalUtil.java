package com.zp.util.general.util;

import java.math.BigDecimal;

/**
 * @author zp
 * @create 2022/1/30 19:58
 * @desc 大数计算工具类
 **/
public class MyBigDecimalUtil {
    //放大倍数
    private static final Integer MAGNIFICATION = 10000;
    //缩小倍数
    private static final Integer LESSEN = 10000;
    //保留位数
    private static final Integer REMAINDER = 2;

    /**
     * 缩小
     *
     * @param obj
     * @return
     */
    public static BigDecimal divide(Long obj) {
        String money = String.valueOf(obj);
        BigDecimal bigDecimal = new BigDecimal(money);
        BigDecimal result = bigDecimal.divide(BigDecimal.valueOf(LESSEN), REMAINDER, BigDecimal.ROUND_UP);
        return result;
    }

    /**
     * 放大
     * @param obj
     * @return
     */
    public static Long multiply(BigDecimal obj) {
        if(obj==null){
            return 0L;
        }
        Long result =obj.multiply(BigDecimal.valueOf(MAGNIFICATION)).longValue();
        return result;
    }
}
