package com.wbw.demo.annotation;

import java.lang.annotation.*;

/**
 * @author wbw
 * @version 1.0
 * @description: 系统日志注解
 * @date 2021-9-10 14:16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
