package com.example.ssm.service;

import com.example.ssm.pojo.User;
import com.example.ssm.util.ServerResponse;


import java.util.Map;

/**
 * @author 周万宁
 * @className UserService
 * @create 2023/5/16-11:20
 * @description
 */
public interface UserService {
    //登录服务
    ServerResponse<User> loginService(Map<String,Object> map);
    //添加用户
    ServerResponse<String> addUser(Map<String,Object> map);
    //删除用户
    ServerResponse<String> deleteUser(int userid);
    //修改用户
    ServerResponse<String> updateUserInfo(Map<String,Object> map);
}
