package com.example.ssm.util;

/**
 * @author 周万宁
 * @className Permission
 * @create 2023/5/17-12:14
 * @description
 */
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    int value();
}
