package com.example.ssm.util;

/**
 * @author 周万宁
 * @className ServerResponseData
 * @create 2023/5/17-11:14
 * @description
 */
public class ServiceResult<T> {

    private int status; // 响应状态码
    private String message; // 响应信息
    private T data; // 响应数据

    public ServiceResult(ResponseDataCode responseCode, T data) {
        this.status = responseCode.getCode();
        this.message = responseCode.getMsg();
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}