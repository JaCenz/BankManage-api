package com.yinhang.api.core;

public enum ResultCode {
    /**
     * 请求成功
     */
    SUCCESS(200),
    /**
     * 请求失败
     */
    FAIL(400),
    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),
    /**
     * 未找到
     */
    NOT_FOUND(404),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    ResultCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
