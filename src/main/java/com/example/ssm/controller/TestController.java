package com.example.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 周万宁
 * @className TestController
 * @create 2023/5/5-13:21
 * @description
 */

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value="/json",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> test(@RequestBody Map<String, Object> requestMap) {
        System.out.println("post请求被访问");
        // 在这里处理 requestMap 中的数据
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("message", "请求成功");
        resultMap.put("data", requestMap);
        return resultMap;
    }

}
