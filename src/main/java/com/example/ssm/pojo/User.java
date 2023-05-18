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
    private int roleId; // 角色id
    private int roleCode; //角色代码
    private String roleName; //角色名称
    private String createTime; //创建时间
    private int authUserId; // 授权人
    private String authUserName; //授权人姓名

    public int getUserId() {
        return userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(int authUserId) {
        this.authUserId = authUserId;
    }

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName;
    }

}
