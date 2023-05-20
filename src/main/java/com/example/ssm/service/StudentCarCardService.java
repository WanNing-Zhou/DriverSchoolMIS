package com.example.ssm.service;

import com.example.ssm.util.ServerResponse;

import java.util.Map;

/**
 * @author 周万宁
 * @className StudentCarCardService
 * @create 2023/5/18-17:27
 * @description
 */

public interface StudentCarCardService {
    /**
     * @MethodName rechargeCardConsume
     * @Author 周万宁
     * @Description 学员练车卡充值
     * @Date 19:04 2023/5/18
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    ServerResponse<String> rechargeCardConsume(Map<String,Object> map);
}
