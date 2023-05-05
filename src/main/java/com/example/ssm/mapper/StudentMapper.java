package com.example.ssm.mapper;

import com.example.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 周万宁
 * @className StudentMapper
 * @create 2023/4/30-22:15
 * @description
 */
@Repository("studentMapperDao")
public interface StudentMapper {
    /**
     * @MethodName getAllStudentInfo
     * @Author 周万宁
     * @Description 获取全部学生信息
     * @Date 16:58 2023/5/4
     * @Param []
     * @return java.util.List<com.example.ssm.pojo.Student>
     **/
    List<Student> getAllStudentInfo();

    /**
     * @MethodName getStudentInfoById
     * @Author 周万宁
     * @Description 根据id获取学生信息
     * @Date 16:58 2023/5/4
     * @Param [id]
     * @return com.example.ssm.pojo.Student
     **/
    Student getStudentInfoById(@Param("id") int id);
}

