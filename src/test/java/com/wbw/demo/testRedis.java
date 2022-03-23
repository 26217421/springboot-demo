package com.wbw.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import com.wbw.demo.entity.User;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-23 11:54
 */
@SpringBootTest
public class testRedis {

    @Autowired(required = false)
    private RedisTemplate redisTemplate;


    @Test
    public void getName(){
        redisTemplate.opsForValue().set("name","dadadingdada!");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
    @Test
    void setObject(){
        User user = new User();
        user.setName("dingdada");
        user.setAge(23);
        user.setHigh(172);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}

