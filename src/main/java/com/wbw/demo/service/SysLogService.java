package com.wbw.demo.service;

import com.wbw.demo.annotation.entity.SysLogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 14:21
 */
@Slf4j
@Service
public class SysLogService {
    public void save(SysLogEntity sysLogEntity){
        log.info("========================================== Start ==========================================");
        log.info("URL            : {}", sysLogEntity.getUrl());
        log.info("Description    : {}", sysLogEntity.getRemark());
        log.info("HTTP Method    : {}", sysLogEntity.getHttpMethod());
        log.info("Class Method   : {}.{}", sysLogEntity.getClassName(), sysLogEntity.getMethodName());
        log.info("IP             : {}", sysLogEntity.getIp());
        log.info("Request Args   : {}", sysLogEntity.getParams());
        log.info("Response Args  : {}", sysLogEntity.getResult());
        log.info("Time-Consuming : {} ms",sysLogEntity.getExeuTime());
        log.info("=========================================== End ===========================================");

    }
}
