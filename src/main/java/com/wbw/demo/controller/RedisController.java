package com.wbw.demo.controller;

import com.wbw.demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-23 12:34
 */
@Slf4j
@RestController
@RequestMapping("redis")
public class RedisController {
    final
    RedisUtil redisUtil;


    @Autowired
    public RedisController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @GetMapping("get")
    public Map<String, Object> getName(String name) {
        Map<String, Object> result = new HashMap<>(1);
        if(name != null) {
            result.put(name, redisUtil.get(name));
        }
        return result;
    }

    @PostMapping("set")
    public String setName(@RequestParam Map<String, Object> params) {
        String key = params.get("key").toString();
        String value = params.get("value").toString();
        redisUtil.set(key, value);
        return "";
    }
}
