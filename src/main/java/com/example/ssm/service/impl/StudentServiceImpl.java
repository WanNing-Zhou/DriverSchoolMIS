package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachCarMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 周万宁
 * @className StudentServiceImpl
 * @create 2023/5/3-13:50
 * @description
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CoachCarMapper coachCarMapper;

    @Override
    public ServerResponse<List<Student>> getAllStudentInfo() {
        List<Student> allStudentInfo = studentMapper.getAllStudentInfo();
        if (allStudentInfo.size()>0){
            return ServerResponse.createBySuccess("查询成功",allStudentInfo);
        }
        return ServerResponse.createByError("查询记录为空");
    }

    @Override
    public ServerResponse<Student> getStudentInfoById(Integer id) {
        Student res = studentMapper.getStudentInfoById(id);
        if (res != null){
            List<CoachCar> coachCarsByStuId = coachCarMapper.getCoachCarsByStuId(id);
            res.setCoachCars(coachCarsByStuId);
            return ServerResponse.createBySuccess("查询成功",res);
        }
        return ServerResponse.createByError("该学生不存在");
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }
}
