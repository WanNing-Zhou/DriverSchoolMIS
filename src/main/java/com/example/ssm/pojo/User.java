package com.example.ssm.pojo;

/**
 * @author 周万宁
 * @className User
 * @create 2023/5/16-11:06
 * @description
 */
public class User {
    private int userId ; //用户id
    private String username; //用户名
    private  String password; //密码
    private String role_code; //角色代码
    private String create_time; //创建时间
    private int auth_user_id; // 授权人
    private String auth_user_name; //授权人姓名

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getAuth_user_id() {
        return auth_user_id;
    }

    public void setAuth_user_id(int auth_user_id) {
        this.auth_user_id = auth_user_id;
    }

    public String getAuth_user_name() {
        return auth_user_name;
    }

    public void setAuth_user_name(String auth_user_name) {
        this.auth_user_name = auth_user_name;
    }
}
