package com.example.ssm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ssm.pojo.User;


import java.util.Date;


/**
 * @author 周万宁
 * @className TokenUtils
 * @create 2023/5/16-11:27
 * @description
 */
// Java 工具类 TokenUtils.java
public class TokenUtils {

    private static String SECRET_KEY = "mySecretKey";    //密钥
    private static long EXPIRE_TIME = 30 * 60 * 1000;     //30分钟到期

    public static String sign(User user) {
        String token = null;
        try {
            Date expireTime = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            token = JWT.create()
                    .withIssuer("auth0")  //设置签发者
                    .withIssuedAt(new Date())  //设置签发时间
                    .withExpiresAt(expireTime)  //设置过期时间
                    .withClaim("id", user.getUserId())  //添加自定义字段
                    .sign(algorithm); //生成jwt签名
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0").build(); // Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);  //验证token
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }
}