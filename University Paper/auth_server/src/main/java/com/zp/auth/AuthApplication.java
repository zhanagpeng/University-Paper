package com.zp.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zp
 * @create 2021/7/15 15:01
 * @desc 用户权限微服务
 **/
@SpringBootApplication(scanBasePackages = "com.zp")
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.zp.auth.*.mapper*")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
