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
    List<CoachCar> getAllCoachCar();
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
}
