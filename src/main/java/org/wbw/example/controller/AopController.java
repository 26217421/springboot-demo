package org.wbw.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wbw.example.annotation.SysLog;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 14:23
 */
@RestController
@RequestMapping("/aop")
public class AopController {
    @SysLog("测试")
    @GetMapping("/test")
    public String test(@RequestParam("name") String name, @RequestParam("age") int age){
        return name + ", " + age;
    }
}
