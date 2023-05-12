package com.example.ssm.service;

import com.example.ssm.pojo.CoachCar;
import com.example.ssm.util.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachCarService
 * @create 2023/5/12-10:54
 * @description
 */

public interface CoachCarService {
    /**
     * @MethodName getAllCoachCar
     * @Author 周万宁
     * @Description 获取全部教练车信息
     * @Date 18:30 2023/5/12
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.CoachCar>>
     **/
    ServerResponse<List<CoachCar>> getAllCoachCar();

    /**
     * @MethodName addCoachChar
     * @Author 周万宁
     * @Description 添加教练车
     * @Date 18:30 2023/5/12
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    ServerResponse<String> addCoachCar(Map<String,Object> map);
    /**
     * @MethodName deleteCoachCar
     * @Author 周万宁
     * @Description 根据Id删除教练车
     * @Date 18:32 2023/5/12
     * @Param [carId]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    ServerResponse<String> deleteCoachCar(int carId);
}
