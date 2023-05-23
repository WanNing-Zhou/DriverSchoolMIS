package com.example.ssm.service;

import com.example.ssm.pojo.User;
import com.example.ssm.util.ServerResponse;
import com.example.ssm.util.ServiceResult;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className UserService
 * @create 2023/5/16-11:20
 * @description
 */
public interface UserService {
    //获取所有用户
    ServerResponse<List> getAllUser();
    //登录服务
    ServerResponse<User> loginService(Map<String,Object> map, HttpServletResponse httpResponse);

    //添加用户
    ServerResponse<String> addUser(Map<String,Object> map);

    //删除用户
    ServerResponse<String> deleteUser(int userId);

    //修改用户
    ServerResponse<String> updateUserInfo(Map<String,Object> map);

    //验证token是否有效
    ServerResponse<String> checkToken(HttpServletRequest request);

    //根据id删除用户
    ServerResponse<String> deleteUserInfo(int userId);

    //根据id获取用户信息
    ServerResponse<User> getUserInfoById(int userId);


}
