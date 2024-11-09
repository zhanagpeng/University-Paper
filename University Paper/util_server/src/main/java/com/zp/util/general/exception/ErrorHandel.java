package com.zp.util.general.exception;


import com.zp.util.general.enums.ErrorCodeEnum;
import com.zp.util.general.enums.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zp
 * @create 2021/7/21 10:14
 * @desc 全局异常拦截器
 **/
@Slf4j
@ControllerAdvice
public class ErrorHandel {
    /**
     * 全局异常拦截
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map globalExceptionHandle(Exception e) {
        Map map = new HashMap<>();
        map.put("code", ErrorCodeEnum.SYSERROR.getCode());
        map.put("status", StatusEnum.FAIL.getCode());
        map.put("msg", "操作失败，请联系系统管理员");
        log.error("异常：【{}】", e);
        return map;
    }
    @ExceptionHandler(value = ZfException.class)
    @ResponseBody
    public Map myExceptionHandle(ZfException e){
        Map map = new HashMap<>();
        map.put("code", ErrorCodeEnum.SYSERROR.getCode());
        map.put("status", false);
        map.put("msg", e.getMsg());
        log.error("异常：【{}】", e);
        return map;
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Map constraintViolationExceptionHandle(ConstraintViolationException e){
        Map map = new HashMap<>();
        map.put("code", ErrorCodeEnum.SYSERROR.getCode());
        map.put("status", false);
        map.put("msg", e.getMessage());
        log.error("异常：【{}】", e);
        return map;
    }
}
