package com.example.ssm.util;

/**
 * @author 周万宁
 * @className Permission
 * @create 2023/5/17-12:14
 * @description 添加到接口上,表示该接口为需要认证的接口
 */
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    int value();
}
