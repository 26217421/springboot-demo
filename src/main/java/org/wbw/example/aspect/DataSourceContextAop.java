package org.wbw.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.wbw.example.annotation.DataSourceSwitcher;
import org.wbw.example.config.domain.DataSourceContextHolder;

import java.lang.reflect.Method;

/**
 * 赋予@DataSourceSwitcher注解能够切换数据源的能力
 * @author wbw
 * @version 1.0
 * @date 2021-9-13 0:37
 */
@Slf4j
@Aspect
@Order(value = 1)
@Component
public class DataSourceContextAop {
    @Around("@annotation(org.wbw.example.annotation.DataSourceSwitcher)")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable {
        boolean clear = false;
        try {
            Method method = this.getMethod(pjp);
            DataSourceSwitcher dataSourceSwitcher = method.getAnnotation(DataSourceSwitcher.class);
            clear = dataSourceSwitcher.clear();
            DataSourceContextHolder.set(dataSourceSwitcher.value().getDataSourceName());
            log.info("数据源切换至：{}", dataSourceSwitcher.value().getDataSourceName());
            return pjp.proceed();
        } finally {
            if (clear) {
                DataSourceContextHolder.clear();
            }

        }
    }

    private Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        return signature.getMethod();
    }
}
