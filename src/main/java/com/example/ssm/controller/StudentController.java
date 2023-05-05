package com.example.ssm.controller;

import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.ServerResponse;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 周万宁
 * @className StudentController
 * @create 2023/5/3-14:08
 * @description
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    /**
     * @MethodName getAllStudentInfo
     * @Author 周万宁
     * @Description 获取全部学生信息接口
     * @Date 17:02 2023/5/4
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.Student>>
     **/
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<Student>> getAllStudentInfo(){

        return studentService.getAllStudentInfo();
    }


    /**
     * @MethodName getStudentInfoById
     * @Author 周万宁
     * @Description 根据id获取学生信息接口
     * @Date 17:02 2023/5/4
     * @Param [id]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.Student>
     **/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Student> getStudentInfoById(@PathVariable("id") Integer id){
        return studentService.getStudentInfoById(id);
    }


}
