package com.example.ssm.service;

import com.example.ssm.pojo.Student;
import com.example.ssm.util.ServerResponse;

import java.util.List;
import java.util.Map;

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

    // 修改学员信息
    ServerResponse<String> updateStudentInfo(Map<String, Object> map);

    //删除学员信息
    ServerResponse<String> deleteStudentInfo(int id);

    //取消学员使用车辆的权限
    ServerResponse<String> cancelStudentUseCarAuth(Map<String,Object> map);

    //添加学员使用车辆权限
    ServerResponse<String> addStudentUseCarAuth(Map<String,Object> map);

    //添加学员信息
    ServerResponse<String> addStudentInfo(Map<String,Object> map);


}
