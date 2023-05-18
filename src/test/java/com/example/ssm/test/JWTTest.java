package com.example.ssm.test;

import com.example.ssm.pojo.User;
import com.example.ssm.util.TokenUtils;
import org.junit.Test;

/**
 * @author 周万宁
 * @className JWTTest
 * @create 2023/5/16-11:56
 * @description
 */
public class JWTTest {
    @Test
    public void authTest() {
        User u = new User();
        u.setUsername("卡卡西");
        u.setRoleId(2);
        System.out.println(u.getUsername());

        TokenUtils tokenUtils = new TokenUtils();
        String token = tokenUtils.generateToken("卡卡西",u.getRoleId());

        System.out.println(token);
        System.out.println(tokenUtils.getUsernameFromToken(token));
        System.out.println(tokenUtils.getRoleCode(token));
    }
}
