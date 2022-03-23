package com.wbw.demo.base.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbw.demo.base.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * @author wbw
 * @version 1.0
 * @description: 请求返回结果封装处理器
 * @date 2021-12-6 23:11
 */
@Slf4j
@RestControllerAdvice
public class ResponseAdviceHandler implements ResponseBodyAdvice {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("wrapping to custom response format");
        if(body instanceof String){
            return objectMapper.writeValueAsString(Result.success(body));
        }
        if(body instanceof Result){
            return body;
        }
        return Result.success(body);

    }
}
