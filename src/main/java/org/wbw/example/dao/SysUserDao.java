package org.wbw.example.dao;

import org.wbw.example.entity.SysUserEntity;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 17:24
 */
public interface SysUserDao {
    /**
     * 根据userId查询用户信息
     * @param userId  用户ID
     * @return 用户信息
     */
    List<SysUserEntity> queryUserInfo(Long userId);

    /**
     * 查询所有用户信息
     */
    List<SysUserEntity> queryUserAll();

    /**
     * 根据userId更新用户的邮箱和手机号
     * @return 更新行数
     */
    int updateUserInfo(SysUserEntity user);
}
