package com.zp.util.general.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**

 * @author  zp

 * @create  2021/2/2 20:40

 * @desc MD5加密工具类

 **/
public class MD5Util {
    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //加密后的字符串
        String newStr = Base64.encodeBase64String(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    /**
     * 判断用户密码是否正确
     * newpasswd 用户输入的密码
     * oldpasswd 正确密码
     */
    public static boolean checkPassword(String newPasswd, String oldPasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (EncoderByMd5(newPasswd).equals(oldPasswd))
            return true;
        else
            return false;
    }
}
