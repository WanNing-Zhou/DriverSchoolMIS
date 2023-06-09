package com.example.ssm.controller;

import com.example.ssm.pojo.Student;
import com.example.ssm.pojo.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.Permission;
import com.example.ssm.util.ServerResponse;
import com.example.ssm.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className UserController
 * @create 2023/5/16-12:05
 * @description
 */


@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;

    /**
     * @MethodName userLogin
     * @Author 周万宁
     * @Description 用户登录
     * @Date 10:05 2023/5/23
     * @Param [requestMap, request, response]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.User>
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> userLogin(@RequestBody Map<String,Object> requestMap, HttpServletRequest request, HttpServletResponse response){
        return userService.loginService(requestMap,response);
    }

    //添加用户接口
    @Permission(1)
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addUSer(@RequestBody Map<String,Object> requestMap){
        return userService.addUser(requestMap);
    }


    /**
     * @MethodName checkToken
     * @Author 周万宁
     * @Description 对token进行验证
     * @Date 21:40 2023/5/20
     * @Param [request]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value = "/token", method =  RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkToken(HttpServletRequest request){
        return userService.checkToken(request);
    }


    /**
     * @MethodName getAllUser
     * @Author 周万宁
     * @Description 获取所有用户信息
     * @Date 16:30 2023/5/22
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List>
     **/
    @Permission(1)
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List> getAllUser(){
        return userService.getAllUser();
    }

    /**
     * @MethodName deleteStudentInfo
     * @Author 周万宁
     * @Description 删除用户信息
     * @Date 16:31 2023/5/22
     * @Param [requestMap]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/

    @Permission(1)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteUserInfo(@RequestBody Map<String,Object> requestMap){

        int id = (int) requestMap.get("userId");
        return  userService.deleteUserInfo(id);
    }

    /**
     * @MethodName getUserInfoById
     * @Author 周万宁
     * @Description 根据id获取用户信息
     * @Date 10:04 2023/5/23
     * @Param [id]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.User>
     **/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Permission(1)
    public ServerResponse<User> getUserInfoById(@PathVariable("id") Integer id){
        return userService.getUserInfoById(id);
    }

    /**
     * @MethodName updateUserInfo
     * @Author 周万宁
     * @Description 更改用户信息
     * @Date 10:11 2023/5/23
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Permission(1)
    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateUserInfo(@RequestBody Map<String,Object> map){
        return userService.updateUserInfo(map);
    }

}
