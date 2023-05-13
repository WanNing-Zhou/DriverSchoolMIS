package com.example.ssm.controller;

import com.example.ssm.pojo.CoachCar;
import com.example.ssm.service.CoachCarService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addCoachCarInfo(@RequestBody Map<String, Object> requestMap){
        return coachCarService.addCoachCar(requestMap);
    }

    //删除车辆信息接口
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteCoachCarInfo(@RequestBody Map<String,Object> requestMap){
        return coachCarService.deleteCoachCar((int) requestMap.get("carId"));
    }


}
