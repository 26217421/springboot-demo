package com.wbw.demo.base.handler;

import com.wbw.demo.base.Result;
import com.wbw.demo.base.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wbw
 * @version 1.0
 * @description: 全局异常处理器
 * @date 2021-12-9 20:13
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e) {
        log.error("全局异常信息 exception={}", e.getMessage(), e);
        return Result.fail(ResultCode.RC500.getCode(),e.getMessage());
    }

}

