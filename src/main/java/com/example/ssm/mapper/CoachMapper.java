package com.example.ssm.mapper;

import com.example.ssm.pojo.Coach;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachMapper
 * @create 2023/4/30-22:14
 * @description
 */
@Repository("coachMapperDao")
public interface CoachMapper {
    /**
     * @MethodName getAllCoaches
     * @Author 周万宁
     * @Description 获取所有教练信息
     * @Date 18:11 2023/5/12
     * @Param []
     * @return java.util.List<com.example.ssm.pojo.Coach>
     **/
    List<Coach> getAllCoaches();
    /**
     * @MethodName deleteByCoachIdInt
     * @Author 周万宁
     * @Description 根据coachId删除教练信息
     * @Date 18:12 2023/5/12
     * @Param [coachId]
     * @return int
     **/
    int deleteByCoachIdInt(@Param("coachId") int coachId);
    /**
     * @MethodName getCoachByIdCoach
     * @Author 周万宁
     * @Description 根据id查询教练操作
     * @Date 18:12 2023/5/12
     * @Param [coachId]
     * @return com.example.ssm.pojo.Coach
     **/
    Coach getCoachByIdCoach(@Param("coachId") int coachId);

    /**
     * @MethodName addCoachInfo
     * @Author 周万宁
     * @Description 添加教练信息
     * @Date 18:20 2023/5/12
     * @Param [params]
     * @return int
     **/
    int addCoachInfo(@Param("params")Map<String,Object> params);

    int updateCoachInfo(@Param("params") Map<String,Object> params);


}
