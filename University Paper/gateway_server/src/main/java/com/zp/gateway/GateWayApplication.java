package com.zp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**

 * @author  zp

 * @create  2021/7/15 11:14

 * @desc    GateWay网关微服务
 **/
@SpringBootApplication(scanBasePackages = "com.zp")
@EnableEurekaClient
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
