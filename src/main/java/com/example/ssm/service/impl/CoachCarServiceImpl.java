package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachCarMapper;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.service.CoachCarService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachCarServiceImpl
 * @create 2023/5/12-10:55
 * @description
 */

@Service
@Transactional
public class CoachCarServiceImpl implements CoachCarService {
    //自动装载
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

    /**
     * @MethodName addCoachCar
     * @Author 周万宁
     * @Description 添加教练车
     * @Date 18:33 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> addCoachCar(Map<String, Object> map) {
        int i = coachCarMapper.addCoachCar(map);
        if(i>0){
            return ServerResponse.createBySuccess("创建成功","success");
        }else{
            return ServerResponse.createByError("创建失败");
        }
    }

    /**
     * @MethodName deleteCoachCar
     * @Author 周万宁
     * @Description 删除教练车
     * @Date 18:33 2023/5/12
     * @Param [carId]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> deleteCoachCar(int carId) {
        int i = coachCarMapper.deleteByCarId(carId);
        if(i>0){
            return ServerResponse.createBySuccess("删除成功","success");
        }else{
            return ServerResponse.createByError("删除数据不存在");
        }
    }
}
