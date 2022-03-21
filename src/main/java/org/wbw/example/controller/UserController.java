package org.wbw.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wbw.example.dao.SysUserDao;
import org.wbw.example.entity.SysUserEntity;
import org.wbw.example.service.SysUserService;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-13 0:51
 */
@RestController
public class UserController {
    @Autowired
    SysUserService userService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/getUserAll")
    private List<SysUserEntity> getUsers() {
        System.out.println("查询副库");
        return userService.queryUserAll();
    }

    /**
     * 根据userId查询用户信息
     * @return
     */
    @GetMapping("/getUserById")
    private List<SysUserEntity> getUserById(@RequestParam(value = "userId", required = false) Long userId) {
        return userService.queryUserInfo(userId);
    }

    /**
     * 根据userId更改用户名
     * @return
     */
    @PostMapping("/upUserById")
    private String updateUserById(@RequestParam(value = "userId") Long userId, @RequestParam
            (value = "userId") String username) {
        SysUserEntity user = new SysUserEntity();
        user.setUserId(userId);
        user.setUsername(username);
        int res = userService.updateUserInfo(user);
        return res == 1 ? "成功" : "失败";
    }
}
