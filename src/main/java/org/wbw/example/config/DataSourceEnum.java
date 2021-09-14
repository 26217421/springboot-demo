package org.wbw.example.config;

import lombok.Getter;

/**
 * @author wbw
 */
@Getter
public enum DataSourceEnum {
    /**
     * 数据源类型名
     */
    MASTER("master"),

    SLAVE("slave");
    
    private final String dataSourceName;

    DataSourceEnum(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

}
