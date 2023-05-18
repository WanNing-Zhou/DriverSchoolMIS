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
    /**
     * @MethodName getCarCardByStuId
     * @Author 周万宁
     * @Description 根据学员id获取练车卡信息
     * @Date 17:41 2023/5/18
     * @Param [stuId]
     * @return com.example.ssm.pojo.StuCarCard
     **/
    StuCarCard getCarCardByStuId(@Param("id") int stuId);
    /**
     * @MethodName deleteCarCardByStuId
     * @Author 周万宁
     * @Description 删除学生西信息的时候注销学生卡
     * @Date 17:41 2023/5/18
     * @Param [stuId]
     * @return int
     **/
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

    /**
     * @MethodName rechargeCardConsume
     * @Author 周万宁
     * @Description 练车卡积分充值
     * @Date 17:25 2023/5/18
     * @Param [map]
     * @return int
     **/
    int rechargeCardConsume(@Param("params") Map<String,Object> map);


}
