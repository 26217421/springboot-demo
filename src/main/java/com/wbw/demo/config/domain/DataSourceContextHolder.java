package com.wbw.demo.config.domain;

/**
 * 利用ThreadLocal封装的保存数据源上线的上下文context
 * @author wbw
 * @version 1.0
 * @date 2021-9-11 18:23
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> context = new ThreadLocal<>();

    /**
     * 赋值
     */
    public static void set(String datasourceType) {
        context.set(datasourceType);
    }

    /**
     * 获取值
     */
    public static String get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
