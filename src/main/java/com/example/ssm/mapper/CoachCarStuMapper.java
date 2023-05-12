package com.example.ssm.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author 周万宁
 * @className CoachCarStu
 * @create 2023/4/30-22:15
 * @description
 */
public interface CoachCarStuMapper {
    int deleteCoachCarInfo(@Param("stuId")int stuId);
}
