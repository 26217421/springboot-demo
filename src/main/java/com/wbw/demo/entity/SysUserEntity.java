package com.wbw.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 16:54
 */
@Data
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer status;

    private Date createTime;
}
