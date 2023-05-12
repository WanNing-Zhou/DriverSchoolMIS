package com.example.ssm.controller;

import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.service.CoachCarService;
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
 * @className CoachCarController
 * @create 2023/5/12-10:53
 * @description
 */
@Controller
@RequestMapping("/coachcar")
public class CoachCarController {

    @Autowired
    private CoachCarService coachCarService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<CoachCar>> getAllCoachCarInfo(){
        return coachCarService.getAllCoachCar();
    }

}
