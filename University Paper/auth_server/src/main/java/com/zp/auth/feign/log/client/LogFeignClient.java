package com.zp.auth.feign.log.client;

import com.zp.auth.feign.log.dto.LogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**

 * @author  zp

 * @create  2022/1/17 19:59

 * @desc    日志feign

 **/
@FeignClient(name = "basicserver",url = "127.0.0.1:8173",path="logController")
@Validated
public interface LogFeignClient {

    @PostMapping("/saveLog.json")
    Map<String, Object> saveLog(@Valid LogDto logDto);
}