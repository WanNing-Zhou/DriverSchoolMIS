package com.example.ssm.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    // token有效期，默认为1天
    private long expiration = 86400000L;

    private String secret = "1212121hsodhsdhasdhsaldhsalhdlsahdlsad";

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 生成JWT Token
     */
    public String generateToken(String username, int userRoleCode) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        Map<String, Object> claims = new HashMap<>();
        claims.put("roleCode", userRoleCode);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)  // 设置自定义的 claim 项
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + expiration))
                .signWith(key, SignatureAlgorithm.HS256);

        return builder.compact();
    }

    /**
     * 验证JWT Token是否合法，并返回 Token 中包含的用户名。Token 验证失败则返回 null。
     */
    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            // Token 验证失败，则直接返回 null
            return null;
        }


    }

    public Integer getRoleCode(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            return (Integer) claims.get("roleCode");
        } catch (Exception e) {
            // Token 验证失败，则直接返回 null
            return null;
        }
    }
}