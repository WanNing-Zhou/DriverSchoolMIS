package com.example.ssm.util;

/**
 * @author 周万宁
 * @className ServerResponseData
 * @create 2023/5/17-11:14
 * @description
 */
public class ServiceResult<T> {

    private int code; // 响应状态码
    private String message; // 响应信息
    private T data; // 响应数据

    public ServiceResult(ResponseDataCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}