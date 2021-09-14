package org.wbw.example.service.impl;

import org.springframework.stereotype.Service;
import org.wbw.example.annotation.DataSourceSwitcher;
import org.wbw.example.config.DataSourceEnum;
import org.wbw.example.dao.SysUserDao;
import org.wbw.example.entity.SysUserEntity;
import org.wbw.example.service.SysUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 17:29
 */
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
    public List<SysUserEntity> queryUserInfo(Long userId) {
        return sysUserDao.queryUserInfo(userId);
    }

    @Override
    @DataSourceSwitcher(DataSourceEnum.SLAVE)
    public List<SysUserEntity> queryUserAll() {
        return sysUserDao.queryUserAll();
    }

    @Override
    @DataSourceSwitcher(DataSourceEnum.MASTER)
    public int updateUserInfo(SysUserEntity user) {
        return sysUserDao.updateUserInfo(user);
    }
}
