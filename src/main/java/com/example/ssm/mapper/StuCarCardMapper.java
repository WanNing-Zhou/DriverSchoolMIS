package com.example.ssm.mapper;

import com.example.ssm.pojo.StuCarCard;
import com.example.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 周万宁
 * @className StuCarCard
 * @create 2023/4/30-22:15
 * @description
 */
public interface StuCarCardMapper {
    StuCarCard getCarCardByStuId(@Param("id") int stuId);
    int deleteCarCardByStuId(@Param("stuId") int stuId);
   /**
    * @MethodName addCarCard
    * @Author 周万宁
    * @Description 添加学员练车卡
    * @Date 14:12 2023/5/12
    * @Param [params]
    * @return int
    **/
    int addCarCard(@Param("params") Map<String,Object> params);
}
