package com.example.ssm.mapper;

import com.example.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    int updateStudentInfo(@Param("params") Map<String,Object> params);

    /**
     * @MethodName deleteStudentInfo
     * @Author 周万宁
     * @Description 删除学生信息
     * @Date 15:21 2023/5/5
     * @Param [id]
     * @return int
     **/
    int deleteStudentInfo(@Param("id") int id);
}

