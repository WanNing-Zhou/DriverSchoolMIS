package com.example.ssm.mapper;

import com.example.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className UserMapper
 * @create 2023/5/16-11:18
 * @description
 */
public interface UserMapper {
    /**
     * @MethodName getUserById
     * @Author 周万宁
     * @Description 根据id查询用户用户判断用户是否存在
     * @Date 12:46 2023/5/18
     * @Param [id]
     * @return com.example.ssm.pojo.User
     **/

    User getUserByUsername(@Param("username") String username);

    /**
     * @MethodName findUserLogin
     * @Author 周万宁
     * @Description 用户登录校验
     * @Date 12:24 2023/5/18
     * @Param [params]
     * @return com.example.ssm.pojo.User
     **/
    User findUserLogin(@Param("params") Map<String,Object> params);
    /**
     * @MethodName addUser
     * @Author 周万宁
     * @Description 添加用户信息
     * @Date 12:42 2023/5/18
     * @Param [params]
     * @return int
     **/
    int addUser(@Param("params") Map<String,Object> params);
    /**
     * @MethodName updateUserInfo
     * @Author 周万宁
     * @Description 更改用户信息, 包括更改用户密码
     * @Date 12:43 2023/5/18
     * @Param [params]
     * @return int
     **/

    int updateUserInfo(@Param("params") Map<String,Object> params);

    /**
     * @MethodName getAllUser
     * @Author 周万宁
     * @Description 获取所有用户信息
     * @Date 19:04 2023/5/18
     * @Param []
     * @return java.util.List<com.example.ssm.pojo.User>
     **/
    List<User> getAllUser();

}
