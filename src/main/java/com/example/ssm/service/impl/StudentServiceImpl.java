package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachCarMapper;
import com.example.ssm.mapper.CoachCarStuMapper;
import com.example.ssm.mapper.StuCarCardMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 周万宁
 * @className StudentServiceImpl
 * @create 2023/5/3-13:50
 * @description
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CoachCarStuMapper coachCarStuMapper;
    @Autowired
    private CoachCarMapper coachCarMapper;
    @Autowired
    private StuCarCardMapper stuCarCardMapper;

    /**
     * @MethodName getAllStudentInfo
     * @Author 周万宁
     * @Description 获取所有学员信息
     * @Date 15:33 2023/5/5
     * @Param []
     * @return com.example.ssm.util.ServerResponse<java.util.List<com.example.ssm.pojo.Student>>
     **/
    @Override
    public ServerResponse<List<Student>> getAllStudentInfo() {
        List<Student> allStudentInfo = studentMapper.getAllStudentInfo();
        if (allStudentInfo.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", allStudentInfo);
        }
        return ServerResponse.createByError("查询记录为空");
    }

    /**
     * @MethodName getStudentInfoById
     * @Author 周万宁
     * @Description 根据Id获取学员信息
     * @Date 15:33 2023/5/5
     * @Param [id]
     * @return com.example.ssm.util.ServerResponse<com.example.ssm.pojo.Student>
     **/
    @Override
    public ServerResponse<Student> getStudentInfoById(Integer id) {
        Student res = studentMapper.getStudentInfoById(id);
        if (res != null) {
            List<CoachCar> coachCarsByStuId = coachCarMapper.getCoachCarsByStuId(id);
            res.setCoachCars(coachCarsByStuId);
            return ServerResponse.createBySuccess("查询成功", res);
        }
        return ServerResponse.createByError("该学生不存在");
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    /**
     * @MethodName updateStudentInfo
     * @Author 周万宁
     * @Description 修改学员信息
     * @Date 15:33 2023/5/5
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> updateStudentInfo(Map<String, Object> map) {
        int res = studentMapper.updateStudentInfo(map);
        if (res > 0) {
            return ServerResponse.createBySuccess("修改成功", "null");
        }
        return ServerResponse.createByError("修改失败");
    }

    /**
     * @MethodName deleteStudentInfo
     * @Author 周万宁
     * @Description 根据id删除学员信息
     * @Date 15:34 2023/5/5
     * @Param [id]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> deleteStudentInfo(int id) {
        stuCarCardMapper.deleteCarCardByStuId(id);
        coachCarStuMapper.deleteCoachCarInfo(id);
        int num = studentMapper.deleteStudentInfo(id);
        if(num>0){
            return ServerResponse.createBySuccess("删除成功","ok");
        }else{
            return ServerResponse.createByError("删除失败");
        }
    }

    /**
     * @MethodName cancelStudentUseCarAuth
     * @Author 周万宁
     * @Description 取消学生使用车辆的权限
     * @Date 10:52 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> cancelStudentUseCarAuth(Map<String, Object> map) {
        return null;
    }
}
