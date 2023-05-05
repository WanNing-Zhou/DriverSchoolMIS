package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.Coach;
import com.example.ssm.service.CoachService;
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
    public List<Coach> getAllCoachInfo() {
        return null;
    }

    @Override
    public Coach getCoachById() {
        return null;
    }

}
