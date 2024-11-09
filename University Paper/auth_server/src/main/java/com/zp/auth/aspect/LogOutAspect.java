package com.zp.auth.aspect;


import com.zp.auth.feign.log.client.LogFeignClient;
import com.zp.auth.feign.log.dto.LogDto;
import com.zp.auth.user.model.User;
import com.zp.auth.user.request.LoginRequest;
import com.zp.auth.user.service.UserService;
import com.zp.util.general.annotation.PointLog;
import com.zp.util.general.enums.LogTypeEnum;
import com.zp.util.general.enums.SysCodeEnum;
import com.zp.util.general.exception.ZfException;
import com.zp.util.general.util.DateUtils;
import com.zp.util.general.util.JedisUtil;
import com.zp.util.general.util.MD5Util;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zp
 * @create 2022/1/18 12:44
 * @desc 登出切面类
 **/
@Slf4j
@Aspect
@Component
public class LogOutAspect {
    @Autowired
    private LogFeignClient logFeignClient;
    @Autowired
    private UserService userService;


    //切点为loginChek()方法
    @Pointcut("execution(* com.zp.auth.user.controller.UserController.logOut(..))")
    private void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String userId = this.handleBefore(pjp);
        //获得方法执行后的返回值
        Object proceed = pjp.proceed();//让目标方法执行
        LogDto logDto = new LogDto();
        logDto.setAction(LogTypeEnum.LOGOUT.getDesc());
        logDto.setCreateUser(userId);
        logFeignClient.saveLog(logDto);
        return proceed;
    }

    private String handleBefore(ProceedingJoinPoint pjp) {
        //获取当前用户ID
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String token = request.getHeader(SysCodeEnum.HEADER_NAME.getCode());
        try(Jedis jedis = JedisUtil.getJedis()){
            return jedis.get(token);
        }
    }
}
