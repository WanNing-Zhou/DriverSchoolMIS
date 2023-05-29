package com.example.ssm.controller;

import com.example.ssm.pojo.CoachCar;
import com.example.ssm.service.CoachCarService;
import com.example.ssm.util.Permission;
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

    /**
     * @MethodName getAllCoachCarInfo
     * @Author 周万宁
     * @Description 获取所有教练车信息
     * @Date 10:55 2023/5/23
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.CoachCar>>
     **/
    @Permission(1)
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<CoachCar>> getAllCoachCarInfo(){
        return coachCarService.getAllCoachCar();
    }

    /**
     * @MethodName addCoachCarInfo
     * @Author 周万宁
     * @Description 添加教练车信息
     * @Date 10:55 2023/5/23
     * @Param [requestMap]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addCoachCarInfo(@RequestBody Map<String, Object> requestMap){
        return coachCarService.addCoachCar(requestMap);
    }

    //删除车辆信息接口
    /**
     * @MethodName deleteCoachCarInfo
     * @Author 周万宁
     * @Description 删除教练车
     * @Date 10:55 2023/5/23
     * @Param [requestMap]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteCoachCarInfo(@RequestBody Map<String,Object> requestMap){
        return coachCarService.deleteCoachCar((int) requestMap.get("carId"));
    }
}
