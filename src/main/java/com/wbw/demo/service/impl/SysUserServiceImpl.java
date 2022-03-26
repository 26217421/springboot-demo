package com.wbw.demo.service.impl;

import com.wbw.demo.annotation.DataSourceSwitcher;
import com.wbw.demo.dao.SysUserDao;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.wbw.demo.config.DataSourceEnum;
import com.wbw.demo.entity.SysUserEntity;
import com.wbw.demo.service.SysUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 17:29
 */
@CacheConfig(cacheNames = {"userCache"})
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    /**
     * 查询用户的所有菜单ID
     * @param userId  用户id
     * @return 用户信息
     */
    @Override
    @DataSourceSwitcher(DataSourceEnum.SLAVE)
    @Cacheable(key = "getTargetClass().name + '.' + getMethodName() + #p0")
    public List<SysUserEntity> queryUserInfo(Long userId) {
        return sysUserDao.queryUserInfo(userId);
    }

    @Override
    @DataSourceSwitcher(DataSourceEnum.SLAVE)
    @Cacheable(key = "targetClass.name + '.' + getMethodName()")
    public List<SysUserEntity> queryUserAll() {
        return sysUserDao.queryUserAll();
    }

    @Override
    @DataSourceSwitcher(DataSourceEnum.MASTER)
    @CachePut(key = "targetClass.name + '.' + getMethodName() + #p0.userId")
    public int updateUserInfo(SysUserEntity user) {
        return sysUserDao.updateUserInfo(user);
    }
}
