package com.example.ssm.mapper;

import com.example.ssm.pojo.CoachCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachCar
 * @create 2023/4/30-22:15
 * @description
 */
public interface CoachCarMapper {
    /**
     * @MethodName getAllCoachCar
     * @Author 周万宁
     * @Description 获取所有教练车信息
     * @Date 9:40 2023/5/12
     * @Param []
     * @return java.util.List<com.example.ssm.pojo.CoachCar>
     **/
    List<CoachCar> getAllCoachCar();
    /**
     * @MethodName getCoachCarById
     * @Author 周万宁
     * @Description 根据id获取教练车信息
     * @Date 18:29 2023/5/29
     * @Param [id]
     * @return com.example.ssm.pojo.CoachCar
     **/
    CoachCar getCoachCarById(@Param("id") int id);
    int updateCoachCarById(@Param("coachCar") Map<String,Object> coachCar);

    /**
     * @MethodName getCoachCarsByStuId
     * @Author 周万宁
     * @Description 根据学员id查找教练车
     * @Date 17:39 2023/5/4
     * @Param [id]
     * @return java.util.List<com.example.ssm.pojo.CoachCar>
     **/

    List<CoachCar> getCoachCarsByStuId(@Param("id") int id);

    int addCoachCar(@Param("params")Map<String,Object> params);

    int deleteByCarId(@Param("carId") int carId);
}
