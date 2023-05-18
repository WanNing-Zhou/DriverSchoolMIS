package com.example.ssm.service.impl;

import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.mapper.UserMapper;
import com.example.ssm.pojo.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.ResponseDataCode;
import com.example.ssm.util.ServerResponse;
import com.example.ssm.util.ServiceResult;
import com.example.ssm.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
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

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public ServerResponse<User> loginService(Map<String, Object> map, HttpServletResponse response) {
        User user = userMapper.findUserLogin(map);

        //如果用户不为null
        if(user!=null && user.getUsername() != null){
            //为用户分配权限
            String token = tokenUtils.generateToken(user.getUsername(), user.getRoleCode());
            //附带响应信息
            response.setHeader("Authorization",token);
            return ServerResponse.createBySuccess("登录成功",user);
        }else{
            return ServerResponse.createByError("用户名或密码错误");
        }
    }
    /**
     * @MethodName addUser
     * @Author 周万宁
     * @Description 添加用户信息
     * @Date 12:44 2023/5/18
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/

    @Override
    public ServerResponse<String> addUser(Map<String, Object> map) {
        User userByName = userMapper.getUserByUsername((String) map.get("username"));

        if(userByName != null && userByName.getUsername() != null){
            return ServerResponse.createByError("该用户已被注册");
        }

        int i = userMapper.addUser(map);
        if(i > 0){
            return ServerResponse.createBySuccess("添加用户成功", "success");
        }else{
            return  ServerResponse.createByError("添加用户失败");
        }
    }

    @Override
    public ServerResponse<String> deleteUser(int userid) {
        return null;
    }

    //修改用户信息
    @Override
    public ServerResponse<String> updateUserInfo(Map<String, Object> map) {

        int i = userMapper.updateUserInfo(map);
        if(i > 0){
            return ServerResponse.createBySuccess("更改用户成功", "success");
        }else{
            return  ServerResponse.createByError("更改用户失败");
        }
    }
}
