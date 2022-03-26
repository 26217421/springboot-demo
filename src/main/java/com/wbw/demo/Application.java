package com.wbw.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 11:22
 */
@EnableCaching
@SpringBootApplication
@MapperScan("com.wbw.demo.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
