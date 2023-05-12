package com.example.ssm.controller;

import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * @MethodName upDataStudentInfo
     * @Author 周万宁
     * @Description 学生数据修改
     * @Date 17:36 2023/5/5
     * @Param [requestMap]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public  ServerResponse<String> upDataStudentInfo(@RequestBody Map<String,Object> requestMap){
/*        System.out.println("输出resquestMap");
        System.out.println(requestMap.get("stuName"));
        System.out.println(requestMap);*/
        return studentService.updateStudentInfo(requestMap);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> deleteStudentInfo(@PathVariable("id")int id){
        return  studentService.deleteStudentInfo(id);
    }

    @RequestMapping(value = "/carAuth/delete/",method = RequestMethod.POST)
    @ResponseBody
    public  ServerResponse<String> cancelStudentUseCarAuth(@RequestBody Map<String,Object> requestMap){
        return null;
    }



}
