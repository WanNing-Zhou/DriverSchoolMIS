package com.example.ssm.service.impl;

import com.example.ssm.mapper.CoachCarMapper;
import com.example.ssm.mapper.CoachCarStuMapper;
import com.example.ssm.mapper.StuCarCardMapper;
import com.example.ssm.mapper.StudentMapper;
import com.example.ssm.pojo.CoachCar;
import com.example.ssm.pojo.Student;
import com.example.ssm.service.StudentService;
import com.example.ssm.util.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ServerResponse<PageInfo> getAllStudentInfo(Map<String,Object> map) {

        PageHelper.startPage((int) map.get("page"),(int)map.get("size"),true);
        List<Student> allStudentInfo = studentMapper.getAllStudentInfo();
        PageInfo<Student> pageInfo = new PageInfo<>(allStudentInfo);
        if (allStudentInfo.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", pageInfo);
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
        int i = coachCarStuMapper.deleteStudentCarMap(map);
        if(i>0){
            return ServerResponse.createBySuccess("删除成功","success");
        }else{
           return ServerResponse.createByError("对应关系不存在");
        }
    }

    /**
     * @MethodName addStudentUseCarAuth
     * @Author 周万宁
     * @Description 添加学员使用车帘权限
     * @Date 11:49 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> addStudentUseCarAuth(Map<String, Object> map) {
        int i = coachCarStuMapper.addStudentCarMap(map);
        if(i>0){
            return ServerResponse.createBySuccess("添加成功","success");
        }else{
            return ServerResponse.createByError("添加失败");
        }
    }


    /**
     * @MethodName addStudentInfo
     * @Author 周万宁
     * @Description 添加学员信息
     * @Date 13:35 2023/5/12
     * @Param [map]
     * @return com.example.ssm.util.ServerResponse<java.lang.String>
     **/
    @Override
    public ServerResponse<String> addStudentInfo(Map<String, Object> map) {
        int affectedRows = studentMapper.addStudentInfo(map);
        System.out.println("affectedRows");
        System.out.println(affectedRows);
        if (affectedRows > 0) {

            // 获取生成的主键id，并将其作为参数传递给 addCarCard 方法
//            int stuId = (int) map.get("stuId");
//            map.put("stuId", stuId);

            // 添加学生卡信息
            int rows = stuCarCardMapper.addCarCard(map);
            if(rows > 0){
                return ServerResponse.createBySuccess("创建成功","success");
            } else{
                return ServerResponse.createByError("创建失败");
            }
        } else {
            return ServerResponse.createByError("创建失败");
        }
    }

}
