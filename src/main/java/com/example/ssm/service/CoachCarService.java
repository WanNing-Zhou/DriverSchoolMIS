package com.example.ssm.service;

import com.example.ssm.pojo.CoachCar;
import com.example.ssm.util.ServerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachCarService
 * @create 2023/5/12-10:54
 * @description
 */

public interface CoachCarService {
    ServerResponse<List<CoachCar>> getAllCoachCar();
}
