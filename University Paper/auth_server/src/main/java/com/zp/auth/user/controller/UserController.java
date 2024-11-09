package com.zp.auth.user.controller;

import com.zp.auth.user.biz.UserBiz;
import com.zp.auth.user.request.LoginRequest;
import com.zp.auth.user.request.UserPageRequest;
import com.zp.auth.user.request.UserRequest;
import com.zp.util.general.annotation.PointLog;
import com.zp.util.general.enums.LogTypeEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zp
 * @create 2021/12/18 16:06
 * @desc 用户控制层
 **/
@RestController
@RequestMapping("/userController")
public class UserController {
    private UserBiz userBiz;

    public UserController(UserBiz userBiz) {
        this.userBiz = userBiz;
    }

    /**
     * 用户登录校验
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/checkUser.form")
    public Map<String, Object> checkUser(@RequestBody LoginRequest loginRequest) {
        return userBiz.checkUserLogin(loginRequest);
    }

    /**
     * 用户登出
     *
     * @return
     */
    @GetMapping("/logOut.json")
    public Map<String, Object> logOut() {
        return userBiz.logOut();
    }

    /**
     * 分页动态查询用户
     *
     * @param userPageRequest
     * @return
     */
    @PointLog(id = LogTypeEnum.USER_MAN)
    @PostMapping("/listUser.json")
    public Map<String, Object> listUser(@RequestBody UserPageRequest userPageRequest) {
        return userBiz.listUser(userPageRequest);
    }

    /**
     * 添加或修改用户
     *
     * @param userRequest
     * @return
     */
    @PostMapping("/addOrUpdateUser.json")
    public Map<String, Object> addOrUpdateUser(@RequestBody UserRequest userRequest) {
        return userBiz.addOrUpdateUser(userRequest);
    }

    /**
     * 根据uId批量删除用户
     *
     * @param uIds
     * @return
     */
    @PostMapping("/deleteBatchUser.json")
    public Map<String, Object> deleteBatchUser(@RequestBody String[] uIds) {
        List<String> uid_list = Arrays.asList(uIds);
        return userBiz.deleteBatchUser(uid_list);
    }

    /**
     * 根据uId查询用户
     *
     * @param uId
     * @return
     */
    @PostMapping("/findUserByUid.json")
    public Map<String, Object> findUserByUid(@RequestBody String uId) {
        return userBiz.findUserByUid(uId);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/selectAllUser.json")
    public Map<String, Object> selectAllUser() {
        return userBiz.selectAllUser();
    }

}
