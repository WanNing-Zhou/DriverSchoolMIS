package com.example.ssm.mapper;

import com.example.ssm.pojo.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 周万宁
 * @className CoachMapper
 * @create 2023/4/30-22:14
 * @description
 */
@Repository("coachMapperDao")
public interface CoachMapper {
    List<Coach> getAllCoaches();
}
