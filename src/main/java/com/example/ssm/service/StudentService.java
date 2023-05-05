package com.example.ssm.service;

import com.example.ssm.pojo.Student;
import com.example.ssm.util.ServerResponse;

import java.util.List;

/**
 * @author 周万宁
 * @className StudentService
 * @create 2023/5/3-13:45
 * @description
 */

public interface StudentService {
    // 获取所有学员信息
    ServerResponse<List<Student>> getAllStudentInfo();
    // 根据学员ID获取学员信息
    ServerResponse<Student> getStudentInfoById(Integer id);
    // 添加学员
    int addStudent(Student student);



}
