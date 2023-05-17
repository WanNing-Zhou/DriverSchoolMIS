package com.example.ssm.util;

/**
 * @author 周万宁
 * @className RoleCode
 * @create 2023/5/17-12:41
 * @description
 */
public enum RoleCode {
    STUDENT(0b1),
    COACHER(0b11),
    MANAGER(0b111);


    private final int roleCode;


    RoleCode(int roleCode){
        this.roleCode = roleCode;
    }

    public int getRoleCode() {
        return roleCode;
    }


}
