package com.example.ssm.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 封装后端返回的Json数据
 */

//保证序列化json时，如果是null的对象，key也会消失
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {

    //状态码
    private int status;
    //数据
    private T data;

    //描述信息
    private String msg;

    //setter、getter方法
    public int getStatus() {
        return status;
    }

    //获取状态
    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
//构造函数
    /**
     * 操作成功时，返回数据
     * @param status
     * @param data
     * @param msg
     */
    public ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public ServerResponse(int status) {
        this.status = status;
    }

    /**
     * 操作失败时，不返回数据
     * @param status
     * @param msg
     */
    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //使之不在序列化结果中
    @JsonIgnore
    public boolean checkIsSuccess(){
        return this.status==ResponseDataCode.SUCCESS.getCode();
    }
//泛型方法

    /**
     * 成功返回数据
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseDataCode.SUCCESS.getCode(),data,msg);
    }

    /**
     * 用于校验登录信息
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByCheckSuccess(){
        return new ServerResponse<T>(ResponseDataCode.SUCCESS.getCode());
    }

    /**
     * 返回错误信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(String msg){
        return new ServerResponse<T>(ResponseDataCode.NOT_FOUND.getCode(),msg);
    }


    public static <T> ServerResponse<T> createByNeedLogin(){
        return new ServerResponse<T>(ResponseDataCode.UNAUTHORIZED.getCode(),"请先登录！");
    }


}
