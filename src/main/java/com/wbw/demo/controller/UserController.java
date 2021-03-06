package com.wbw.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wbw.demo.entity.SysUserEntity;
import com.wbw.demo.service.SysUserService;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-13 0:51
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    SysUserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/getUserAll")
    public List<SysUserEntity> getUsers() {
        log.info("查询副库");
        return userService.queryUserAll();
    }

    /**
     * 根据userId查询用户信息
     * @return
     */
    @GetMapping("/getUserById")
    public List<SysUserEntity> getUserById(@RequestParam(value = "userId", required = false) Long userId) {
        return userService.queryUserInfo(userId);
    }

    /**
     * 根据userId更改用户名
     * @return
     */
    @PostMapping("/upUserById")
    public String updateUserById(@RequestParam(value = "userId") Long userId, @RequestParam
            (value = "userId") String username) {
        SysUserEntity user = new SysUserEntity();
        user.setUserId(userId);
        user.setUsername(username);
        int res = userService.updateUserInfo(user);
        return res == 1 ? "成功" : "失败";
    }
}
