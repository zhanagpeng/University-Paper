package com.zp.util.general.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**

 * @author  zp

 * @create  2021/12/18 10:42

 * @desc    jwt加密工具类

 **/
public abstract class JwtUtil {
    /**
     * 秘钥不能暴露，否则会被攻击
     */
    private static final String JWT_SEC="E4791AB6F7FF4EAEB33F3E16613D5E9F*jdk&gJw%tE#ncry^p1";
    /**
     * token过期时间,2小时
     */
    public static final Integer TTL_MILLIS=2*60*60*1000;
    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定JWT_SEC秘钥
     *
     * @param userId  用户ID 可根据需要传递的信息添加更多, 因为浏览器get传参url限制，不建议放置过多的参数
     * @return
     */
    public static String createJWT(String userId) {
        // 指定签名的时候使用的签名算法，也就是header那部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 创建payload的私有声明（根据特定的业务需要添加）
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userId", userId);

        // 添加payload声明
        // 设置jwt的body
        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                // iat: jwt的签发时间
                .setIssuedAt(now)
                // 代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串
                .setSubject(userId)
                // 设置签名使用的
                .signWith(signatureAlgorithm, JWT_SEC.getBytes(StandardCharsets.UTF_8));
        if (TTL_MILLIS >= 0) {
            long expMillis = nowMillis + TTL_MILLIS;
            Date exp = new Date(expMillis);
            // 设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }


    /**
     * Token的解密
     *
     * @param token  加密后的token
     * @return
     */
    public static Claims parseJWT(String token) {
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
                // 设置签名的秘钥
                .setSigningKey(JWT_SEC.getBytes(StandardCharsets.UTF_8))
                // 设置需要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }

}