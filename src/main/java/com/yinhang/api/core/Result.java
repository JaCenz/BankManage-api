package com.yinhang.api.core;
import com.alibaba.fastjson.JSON;

public class Result<T> {
    private int code;
    private T data;
    private String message;

    public int getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
