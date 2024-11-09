package com.zp.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**

 * @author  zp

 * @create  2021/7/15 15:15

 * @desc  基础微服务

 **/
@SpringBootApplication(scanBasePackages = "com.zp")
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.zp.basic.*.mapper*")
public class BasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class,args);
    }
}
