package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.CoachService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachServiceImpl
 * @create 2023/5/3-13:51
 * @description
 */
@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;
    @Override
    public ServerResponse<List<Coach>> getAllCoachInfo() {
        List<Coach> allCoaches = coachMapper.getAllCoaches();
        if(allCoaches.size()>0){
            return ServerResponse.createBySuccess("查询成功",allCoaches);
        }
        return ServerResponse.createByError("查询失败");
    }

    @Override
    public Coach getCoachById() {
        return null;
    }

}
