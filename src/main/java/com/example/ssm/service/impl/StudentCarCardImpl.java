package com.example.ssm.service.impl;

import com.example.ssm.mapper.StuCarCardMapper;
import com.example.ssm.service.StudentCarCardService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author 周万宁
 * @className StudentCarCardImpl
 * @create 2023/5/18-17:29
 * @description
 */
@Service
@Transactional
public class StudentCarCardImpl implements StudentCarCardService {

    @Autowired
    StuCarCardMapper stuCarCardMapper;
    @Override
    public ServerResponse<String> rechargeCardConsume(Map<String, Object> map) {
        int i = stuCarCardMapper.rechargeCardConsume(map);
        if(i>0){
            return ServerResponse.createBySuccess("充值成功","success");
        }else{
            return ServerResponse.createByError("充值失败");
        }
    }


}
