package com.example.ssm.controller;

import com.example.ssm.service.StudentCarCardService;
import com.example.ssm.util.Permission;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 周万宁
 * @className StudentCardController
 * @create 2023/5/18-17:14
 * @description
 */
@RequestMapping("/card")
@Controller
public class StudentCardController {
    @Autowired
    StudentCarCardService studentCarCardService;
    @RequestMapping("/recharge")
    @ResponseBody
    @Permission(1)
    public ServerResponse<String> cardRecharge(@RequestBody Map<String, Object> map){
        return studentCarCardService.rechargeCardConsume(map);
    }
}
