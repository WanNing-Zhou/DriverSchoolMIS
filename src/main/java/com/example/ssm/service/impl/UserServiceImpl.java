package com.example.ssm.service.impl;

import com.example.ssm.pojo.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author 周万宁
 * @className UserServiceImpl
 * @create 2023/5/16-12:03
 * @description
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public ServerResponse<User> loginService(Map<String, Object> map) {
        return null;
    }

    @Override
    public ServerResponse<String> addUser(Map<String, Object> map) {
        return null;
    }

    @Override
    public ServerResponse<String> deleteUser(int userid) {
        return null;
    }

    @Override
    public ServerResponse<String> updateUserInfo(Map<String, Object> map) {
        return null;
    }
}
