package com.wbw.demo.base.exception;

import com.wbw.demo.base.constants.ResultCode;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbw
 * @version 1.0
 * @description: 自定义异常基类
 * @date 2021-12-9 21:10
 */
public abstract class BaseException extends RuntimeException {
    private final ResultCode error;
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ResultCode error, Map<String, Object> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ResultCode error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    public ResultCode getError() {
        return error;
    }

    public Map<String, Object> getData() {
        return data;
    }
}

