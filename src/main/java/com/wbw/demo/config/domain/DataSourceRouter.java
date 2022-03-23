package com.wbw.demo.config.domain;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *  数据源路由的配置
 *
 * @author wbw
 * @date 2021-9-11 18:22
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

    /**
     * 最终的determineCurrentLookupKey返回的是从DataSourceContextHolder中拿到的,因此在动态切换数据源的时候注解
     * 应该给DataSourceContextHolder设值
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();

    }
}
