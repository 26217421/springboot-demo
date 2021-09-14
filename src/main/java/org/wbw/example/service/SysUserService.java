package org.wbw.example.service;

import org.wbw.example.entity.SysUserEntity;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 17:29
 */
public interface SysUserService {
    /**
     * 查询用户的所有菜单ID
     * @param userId  用户id
     * @return 用户信息
     */
    List<SysUserEntity> queryUserInfo(Long userId);

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    List<SysUserEntity> queryUserAll();

    /**
     * 根据userId更新用户信息
     * @return 更新行数
     * @param user
     */
    int updateUserInfo(SysUserEntity user);

}
