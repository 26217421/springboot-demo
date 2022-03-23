package com.wbw.demo.annotation;

import com.wbw.demo.config.DataSourceEnum;

import java.lang.annotation.*;

/**
 * 进行数据源的切换
 * @author wbw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSwitcher {
    /**
     * 默认数据源
     */
    DataSourceEnum value() default DataSourceEnum.MASTER;
    /**
     * 清除
     */
    boolean clear() default true;
}
