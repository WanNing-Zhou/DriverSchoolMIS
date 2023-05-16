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
    public void jwtTest(){
        User user1 = new User();
        user1.setUserId(123);
        String sign = TokenUtils.sign(user1);
        System.out.println(sign);
        System.out.println(TokenUtils.verify(sign));
    }
}
