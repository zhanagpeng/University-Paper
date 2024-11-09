package com.zp.gateway.fliter;

import com.zp.gateway.common.WhiteListInIt;

import com.zp.gateway.common.enums.SysCodeEnum;
import com.zp.gateway.util.JedisUtil;
import com.zp.gateway.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;

/**
 * @author zp
 * @create 2021/7/20 15:02
 * @desc 全局鉴权过滤器
 **/
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    /**
     * 过滤逻辑
     * 判断请求是否携带token(ServerWebExchange是请求上下文),有，放行，无，拦截
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //获取请求路径
        String path = request.getURI().getPath();
        //判断是否开启请求拦截
        if (StringUtils.equals(WhiteListInIt.onSwitch, "false")) {
            return chain.filter(exchange);//放行
        }
        //判断白名单
        if (WhiteListInIt.whiteList.contains(path)) {
            return chain.filter(exchange);//放行
        }
        //非白名单进行拦截，获取请求头中的token
        String token = request.getHeaders().getFirst(SysCodeEnum.HEADER_NAME.getCode());
        if (StringUtils.isEmpty(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//无权限状态码
            return exchange.getResponse().setComplete();//结束请求
        }
        //携带token的请求需要进行校验，校验成功对token、uanme的过期时间进行更新
        Jedis jedis = JedisUtil.getJedis();
        String localUid = jedis.get(token);//token的key取出来是uId
        if (StringUtils.isEmpty(localUid)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//无权限状态码
            return exchange.getResponse().setComplete();//结束请求
        }
        //延长过期时间
        jedis.expire(token, JwtUtil.TTL_MILLIS);
        jedis.expire(localUid, JwtUtil.TTL_MILLIS);

        return chain.filter(exchange);//放行
    }


    /**
     * 过滤器的优先级
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
