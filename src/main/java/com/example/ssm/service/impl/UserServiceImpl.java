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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.List;
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
            System.out.println("用户名"+ user.getUsername());
            String token = tokenUtils.generateToken(user.getUsername(), user.getRoleId());
            System.out.println("解签后的用户名"+tokenUtils.getUsernameFromToken(token));
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


    /**
     * @MethodName checkToken
     * @Author 周万宁
     * @Description 验证用户token是否有效
     * @Date 20:44 2023/5/20
     * @Param [request]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> checkToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = tokenUtils.getUsernameFromToken(token);
        if(username != null && username != ""){
            int roleId = tokenUtils.getRoleCode(token);
            return ServerResponse.createBySuccess("token有效", ""+roleId);
        }else{
            return ServerResponse.createByError("token无效,请重新登录");
        }
    }

    /**
     * @MethodName getAllUser
     * @Author 周万宁
     * @Description 获取所有用户
     * @Date 16:21 2023/5/22
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List>
     **/
    @Override
    public ServerResponse<List> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        if(allUser.size() > 0){
            return  ServerResponse.createBySuccess("查询成功",allUser);
        }else {
            return ServerResponse.createByError("查询失败");
        }
    }

    /**
     * @MethodName deleteUserInfo
     * @Author 周万宁
     * @Description 根据用户id删除用户信息
     * @Date 9:21 2023/5/23
     * @Param [userId]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> deleteUserInfo(int userId) {
        int i = userMapper.deleteByUserId(userId);
        if(i>0){
            return ServerResponse.createBySuccess("删除成功","ok");
        }else{
            return ServerResponse.createByError("删除失败");
        }
    }

    /**
     * @MethodName getUserInfoById
     * @Author 周万宁
     * @Description 根据id获取用户信息
     * @Date 9:21 2023/5/23
     * @Param [userId]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.User>
     **/
    @Override
    public ServerResponse<User> getUserInfoById(int userId) {
        User userInfoById = userMapper.getUserInfoById(userId);
        if(userInfoById != null){
            return ServerResponse.createBySuccess("查询成功",userInfoById);
        }else{
            return ServerResponse.createByError("查询失败");
        }

    }
}
