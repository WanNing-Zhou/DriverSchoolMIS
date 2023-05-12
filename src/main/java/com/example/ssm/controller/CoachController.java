package com.example.ssm.controller;

import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.CoachService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteCoachInfo(@RequestBody Map<String,Object> requestMap){
        return coachService.deleteCoachInfo((int) requestMap.get("coachId"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Coach> getCoachInfoById(@PathVariable("id") Integer id){
        return coachService.getCoachById(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addCoachInfo(@RequestBody Map<String, Object> requestMap){
        return coachService.addCoachInfo(requestMap);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateCoachInfo(@RequestBody Map<String,Object> requestMap){
        return coachService.updateCoachInfo(requestMap);
    }
}