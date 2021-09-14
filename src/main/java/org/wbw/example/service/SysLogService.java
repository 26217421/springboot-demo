package org.wbw.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wbw.example.annotation.entity.SysLogEntity;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-9-10 14:21
 */
@Slf4j
@Service
public class SysLogService {
    public boolean save(SysLogEntity sysLogEntity){
        // 这里就不做具体实现了
        log.info(sysLogEntity.getParams());
        return true;
    }
}
