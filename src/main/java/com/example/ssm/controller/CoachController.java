package com.example.ssm.controller;

import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.CoachService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachController
 * @create 2023/5/5-12:13
 * @description
 */
@Controller
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<Coach>> getAllCoachInfo(){
        return coachService.getAllCoachInfo();
    }

}
