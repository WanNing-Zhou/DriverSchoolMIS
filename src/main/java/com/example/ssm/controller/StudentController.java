package com.example.ssm.controller;

import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.Permission;
import com.example.ssm.util.ServerResponse;
import com.github.pagehelper.PageInfo;
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
     * @return com.example.ssm.util.ServerResponse<java.util.List < com.example.ssm.pojo.Student>>
     * @MethodName getAllStudentInfo
     * @Author 周万宁
     * @Description 获取全部学生信息接口
     * @Date 17:02 2023/5/4
     * @Param []
     **/

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody

    public ServerResponse<PageInfo> getAllStudentInfo(@RequestBody Map<String, Object> map) {
        return studentService.getAllStudentInfo(map);
    }


    /**
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.Student>
     * @MethodName getStudentInfoById
     * @Author 周万宁
     * @Description 根据id获取学生信息接口
     * @Date 17:02 2023/5/4
     * @Param [id]
     **/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Student> getStudentInfoById(@PathVariable("id") Integer id) {
        return studentService.getStudentInfoById(id);
    }

    /**
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     * @MethodName upDataStudentInfo
     * @Author 周万宁
     * @Description 学生数据修改
     * @Date 17:36 2023/5/5
     * @Param [requestMap]
     **/
    @Permission(1)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> upDataStudentInfo(@RequestBody Map<String, Object> requestMap) {
        return studentService.updateStudentInfo(requestMap);
    }

    /**
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     * @MethodName deleteStudentInfo
     * @Author 周万宁
     * @Description 删除学员信息
     * @Date 10:53 2023/5/23
     * @Param [requestMap]
     **/
    @Permission(1)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteStudentInfo(@RequestBody Map<String, Object> requestMap) {
        int id = (int) requestMap.get("stuId");
        return studentService.deleteStudentInfo(id);
    }

    /**
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     * @MethodName cancelStudentUseCarAuth
     * @Author 周万宁
     * @Description 取消学员车辆授权
     * @Date 10:53 2023/5/23
     * @Param [requestMap]
     **/
    @RequestMapping(value = "/carAuth/delete", method = RequestMethod.POST)
    @ResponseBody
    @Permission(1)
    public ServerResponse<String> cancelStudentUseCarAuth(@RequestBody Map<String, Object> requestMap) {

        return studentService.cancelStudentUseCarAuth(requestMap);
    }

    /**
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     * @MethodName addStudentUseCarAuth
     * @Author 周万宁
     * @Description 添加学员车辆授权
     * @Date 10:53 2023/5/23
     * @Param [requestMap]
     **/
    @Permission(1)
    @RequestMapping(value = "/carAuth/add", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addStudentUseCarAuth(@RequestBody Map<String, Object> requestMap) {
        return studentService.addStudentUseCarAuth(requestMap);
    }

    /**
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     * @MethodName addStudentInfo
     * @Author 周万宁
     * @Description 添加学员信息
     * @Date 10:54 2023/5/23
     * @Param [requestMap]
     **/
    @Permission(1)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addStudentInfo(@RequestBody Map<String, Object> requestMap) {
        return studentService.addStudentInfo(requestMap);
    }


}
