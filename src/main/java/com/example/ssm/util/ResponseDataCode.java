package com.example.ssm.util;

/**
 * @author 周万宁
 * @className ResponseDataCode
 * @create 2023/5/17-11:16
 * @description
 */
public enum ResponseDataCode {

    SUCCESS(200, "请求成功"), // 请求成功
    BAD_REQUEST(400, "请求参数有误"), // 请求参数有误
    UNAUTHORIZED(401, "未认证或身份信息已过期"), // 未认证或身份信息已过期
    FORBIDDEN(403, "权限不足"), // 权限不足
    NOT_FOUND(404, "请求的资源不存在"), // 请求的资源不存在
    SERVER_ERROR(500, "服务器错误"); // 服务器错误

    private final int code;
    private final String msg;

    ResponseDataCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}