package com.wbw.demo.base;

import com.wbw.demo.base.constants.ResultCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * @author wbw
 * @version 1.0
 * @description: 同意返回格式
 * @date 2021-12-6 20:38
 */
@Data
@Slf4j
public class Result<T> implements Serializable {
    /** 结果状态 ,具体状态码参见ResultData.java*/
    private int code;
    private String message;
    private T data;
    private long timestamp ;


    public Result(){
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> Result<T> success(T data) {
        Result<T> resultData = new Result<>();
        resultData.setCode(ResultCode.RC100.getCode());
        resultData.setMessage(ResultCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> Result<T> fail(int code, String message) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
    public static <T> Result<T> fail(ResultCode result) {
        Result<T> resultData = new Result<>();
        resultData.setCode(result.getCode());
        resultData.setMessage(result.getMessage());
        return resultData;
    }

/*    public static void resJsonFail(HttpServletResponse response, ResultCode rc) {
        String result = JSONObject.toJSONString(Result.fail(rc.getCode(), rc.getMessage()));
        resJson(response, result);
    }*/

    private static void resJson(HttpServletResponse response, String result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/json;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println(result);
            log.info("返回Json:{}",result);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            Objects.requireNonNull(out).flush();
            out.close();
        }
    }

    /*public static void resJsonSuccess(HttpServletResponse response, Map data) {
        String result = JSON.toJSONString(Result.success(data));
        resJson(response, result);
    }*/

}
