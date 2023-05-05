package com.example.ssm.mapper;

import com.example.ssm.pojo.StuCarCard;
import org.apache.ibatis.annotations.Param;

/**
 * @author 周万宁
 * @className StuCarCard
 * @create 2023/4/30-22:15
 * @description
 */
public interface StuCarCardMapper {
    StuCarCard getCarCardByStuId(@Param("id") int stuId);
}
