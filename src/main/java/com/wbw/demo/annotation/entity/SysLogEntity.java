package com.wbw.demo.annotation.entity;

import lombok.Data;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 14:20
 */
@Data
public class SysLogEntity {
    private String className;
    private String methodName;
    private String params;
    private Long exeuTime;
    private String remark;
    private String createDate;
}
