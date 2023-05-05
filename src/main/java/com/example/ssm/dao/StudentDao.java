package com.example.ssm.dao;

import com.example.ssm.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周万宁
 * @className StudentDao
 * @create 2023/5/3-13:23
 * @description
 */



public class StudentDao {

    public List<Student> getAllStudentInfo(){
        List<Student> k = new ArrayList<>();

        return k;
    }
}
