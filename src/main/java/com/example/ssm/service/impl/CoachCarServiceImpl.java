package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachCarMapper;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.service.CoachCarService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachCarServiceImpl
 * @create 2023/5/12-10:55
 * @description
 */

@Service
@Transactional
public class CoachCarServiceImpl implements CoachCarService {
    @Autowired
    private CoachCarMapper coachCarMapper;

    /**
     * @MethodName getAllCoachCar
     * @Author 周万宁
     * @Description 获取所有教练车
     * @Date 11:07 2023/5/12
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.CoachCar>>
     **/
    @Override
    public ServerResponse<List<CoachCar>> getAllCoachCar(){

        List<CoachCar> allCoachCar = coachCarMapper.getAllCoachCar();
        if(allCoachCar.size()>0){
            return ServerResponse.createBySuccess("查询成功",allCoachCar);
        }
        return ServerResponse.createByError("查询失败");

    }
}
