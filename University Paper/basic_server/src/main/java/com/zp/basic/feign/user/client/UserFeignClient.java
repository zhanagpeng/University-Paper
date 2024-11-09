package com.zp.basic.feign.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zp
 * @create 2022/1/22 11:05
 * @desc 用户feign
 **/
@FeignClient(name = "authserver", url = "127.0.0.1:8174", path = "userController")
@Validated
public interface UserFeignClient {
    /**
     * 根据ID查询用户
     *
     * @param receiveMan
     * @return
     */
    @PostMapping("/findUserByUid.json")
    Object findUserByUid(String receiveMan);
}
