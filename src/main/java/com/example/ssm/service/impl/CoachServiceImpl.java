package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.Coach;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.CoachService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className CoachServiceImpl
 * @create 2023/5/3-13:51
 * @description
 */
@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * @MethodName getAllCoachInfo
     * @Author 周万宁
     * @Description 获取所有教练信息
     * @Date 18:15 2023/5/12
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.Coach>>
     **/
    @Override
    public ServerResponse<List<Coach>> getAllCoachInfo() {
        List<Coach> allCoaches = coachMapper.getAllCoaches();
        if(allCoaches.size()>0){
            return ServerResponse.createBySuccess("查询成功",allCoaches);
        }
        return ServerResponse.createByError("查询失败");
    }

    /**
     * @MethodName getCoachById
     * @Author 周万宁
     * @Description 根据coachId获取coach信息
     * @Date 18:16 2023/5/12
     * @Param [coachId]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.Coach>
     **/
    @Override
    public ServerResponse<Coach> getCoachById(int coachId) {
        Coach coachByIdCoach = coachMapper.getCoachByIdCoach(coachId);
        if(coachByIdCoach != null){
            List<Student> students = studentMapper.getByCoachId(coachId);
            coachByIdCoach.setStudents(students);
            return ServerResponse.createBySuccess("查询成功",coachByIdCoach);
        }else{
            return ServerResponse.createByError("查询失败");
        }
    }

    /**
     * @MethodName deleteCoachInfo
     * @Author 周万宁
     * @Description 根据coachId删除教练信息
     * @Date 18:16 2023/5/12
     * @Param [coachId]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> deleteCoachInfo(int coachId) {
        int i = coachMapper.deleteByCoachIdInt(coachId);
        if(i>0){
            return ServerResponse.createBySuccess("删除成功","success");
        }else{
            return  ServerResponse.createByError("删除失败");
        }
    }

    /**
     * @MethodName addCoachInfo
     * @Author 周万宁
     * @Description 添加教练信息
     * @Date 18:19 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> addCoachInfo(Map<String, Object> map) {
        int i = coachMapper.addCoachInfo(map);
        if(i>0){
            return ServerResponse.createBySuccess("创建成功","success");
        }else{
            return ServerResponse.createByError("创建失败");
        }
    }

    /**
     * @MethodName updateCoachInfo
     * @Author 周万宁
     * @Description 修改教练信息
     * @Date 20:11 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> updateCoachInfo(Map<String, Object> map) {
        int i = coachMapper.updateCoachInfo(map);
        if(i>0){
            return ServerResponse.createBySuccess("修改成功","success");
        }else{
            return ServerResponse.createByError("修改失败");
        }
    }
}
