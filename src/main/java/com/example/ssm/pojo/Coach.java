package com.example.ssm.pojo;

import java.util.List;

/**
 * @author 周万宁
 * @className Coach
 * @create 2023/4/30-21:59
 * @description 教练pojo
 */

public class Coach {

    private String coachName;
    private int coachId;
    private String coachPhone;
    private String coachGender;
    private String coachExperience;
    private List<Student> students;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachPhone() {
        return coachPhone;
    }

    public void setCoachPhone(String coachPhone) {
        this.coachPhone = coachPhone;
    }

    public String getCoachGender() {
        return coachGender;
    }

    public void setCoachGender(String coachGender) {
        this.coachGender = coachGender;
    }

    public String getCoachExperience() {
        return coachExperience;
    }

    public void setCoachExperience(String coachExperience) {
        this.coachExperience = coachExperience;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
