package com.wbw.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.wbw.demo.entity.SysUserEntity;
import com.wbw.demo.service.SysUserService;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    private final static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void queryUserInfo() throws Exception {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId(10199L);
        //List<SysUserEntity> list = sysUserService.queryUserInfo(userEntity.getUserId());
        List<SysUserEntity> list = sysUserService.queryUserAll();
        logger.info("list:" + list);
    }

    @Test
    public void updateUserInfo() throws Exception {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId(10081L);
        userEntity.setUsername("sad");
        int res = sysUserService.updateUserInfo(userEntity);
        logger.info("res:" + res);
    }



}
