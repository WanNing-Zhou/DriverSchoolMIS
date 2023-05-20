package com.example.ssm.controller;

import com.example.ssm.pojo.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.ServerResponse;
import com.example.ssm.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> userLogin(@RequestBody Map<String,Object> requestMap, HttpServletRequest request, HttpServletResponse response){
        return userService.loginService(requestMap,response);
    }

    //添加用户接口
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addUSer(@RequestBody Map<String,Object> requestMap){
        System.out.println("kkk");
        System.out.println(requestMap);
        return userService.addUser(requestMap);
    }
}
