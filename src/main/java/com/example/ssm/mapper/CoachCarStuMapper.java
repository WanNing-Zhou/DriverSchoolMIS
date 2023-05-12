package com.example.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 周万宁
 * @className CoachCarStu
 * @create 2023/4/30-22:15
 * @description
 */
public interface CoachCarStuMapper {
    /**
     * @MethodName deleteCoachCarInfo
     * @Author 周万宁
     * @Description 根据学员Id删除对应关系
     * @Date 11:33 2023/5/12
     * @Param [stuId]
     * @return int
     **/
    int deleteCoachCarInfo(@Param("stuId")int stuId);

    /**
     * @MethodName deleteStudentCarMap
     * @Author 周万宁
     * @Description 根据学员id与车辆id来取消对应关系
     * @Date 11:36 2023/5/12
     * @Param [studentCarMap]
     * @return int
     **/
    int deleteStudentCarMap(@Param("studentCarMap")Map<String,Object> studentCarMap);

    /**
     * @MethodName addStudentCarMap
     * @Author 周万宁
     * @Description 根据学员id与车辆id来添加对应关系
     * @Date 11:58 2023/5/12
     * @Param [studentCarMap]
     * @return int
     **/
    int addStudentCarMap(@Param("studentCarMap") Map<String,Object> studentCarMap);

}
