package com.example.ssm.service;

import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.util.ServerResponse;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachService
 * @create 2023/5/3-13:45
 * @description
 */
public interface CoachService {
    //查看教练信息
    ServerResponse<List<Coach>> getAllCoachInfo();

    // 根据id获取教练信息
    Coach getCoachById();

}
