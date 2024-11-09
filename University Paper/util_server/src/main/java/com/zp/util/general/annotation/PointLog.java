package com.zp.util.general.annotation;

import com.zp.util.general.enums.LogTypeEnum;

import java.lang.annotation.*;

/**

 * @author  zp

 * @create  2022/1/16 17:01

 * @desc    aop自定义注解

 **/
//表示该注解用于什么地方。默认值为任何元素，表示该注解用于什么地方,参数和方法
//(包 方法)
@Target({ElementType.PACKAGE, ElementType.METHOD})
//定义该注解的生命周期
//(始终不会被丢弃运行期也保留)
@Retention(RetentionPolicy.RUNTIME)
@Documented//表示是否将注解信息添加在java文档中
public @interface PointLog {
    //功能枚举
    LogTypeEnum id() default LogTypeEnum.INDEX;
}
