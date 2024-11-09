package com.zp.auth.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.auth.user.model.User;
import com.zp.auth.user.request.UserPageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zp
 * @create 2021/12/18 17:11
 * @desc 用户持久层
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 动态分页查询用户
     * @param userPage
     * @param userPageRequest
     * @return
     */
    IPage<User> listUser(@Param("userPage") IPage<User> userPage,@Param("userPageRequest") UserPageRequest userPageRequest);


}
