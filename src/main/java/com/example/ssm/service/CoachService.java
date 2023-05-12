package com.example.ssm.service;

import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.util.ServerResponse;
import net.sf.jsqlparser.schema.Server;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachService
 * @create 2023/5/3-13:45
 * @description
 */
public interface CoachService {
    //获取所有教练信息
    ServerResponse<List<Coach>> getAllCoachInfo();

    // 根据id获取教练信息
    ServerResponse<Coach> getCoachById(int coachId);


    //根据id删除教练信息
    ServerResponse<String> deleteCoachInfo(int coachId);

    //添加教练信息
    ServerResponse<String> addCoachInfo(Map<String,Object> map);

    //修改教练信息
    ServerResponse<String> updateCoachInfo(Map<String,Object> map);

}
