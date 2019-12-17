package com.yinhang.api.core;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private static final Logger logger = LoggerFactory.getLogger(ResultGenerator.class);

    public static <T> Result success(T data){
        return new Result<T>()
                .setCode(ResultCode.SUCCESS)
                .setData(data)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result success(T data,String message){
        return new Result<T>()
                .setCode(ResultCode.SUCCESS)
                .setData(data)
                .setMessage(message);
    }

    public static Result fail(String message){
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static void responseResult(HttpServletResponse response, Result result){
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.setStatus(result.getCode());
        try {
            response.getWriter().write(JSON.toJSONString(result));
        }catch (IOException ex){
            logger.error(ex.getMessage());
        }
    }
}
