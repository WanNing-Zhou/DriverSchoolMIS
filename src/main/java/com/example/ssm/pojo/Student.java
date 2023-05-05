package com.example.ssm.pojo;

import java.util.List;

/**
 * @author 周万宁
 * @className Student
 * @create 2023/4/30-22:12
 * @description 学员
 */
public class Student {
    private int stuId;
    private String stuName;
    private int age;
    private char sex;
    private String email;
    private StuCarCard stuCarCard;
    private Coach coach;
    private List<CoachCar> coachCars;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StuCarCard getStuCarCard() {
        return stuCarCard;
    }

    public void setStuCarCard(StuCarCard stuCarCard) {
        this.stuCarCard = stuCarCard;
    }


    public List<CoachCar> getCoachCars() {
        return coachCars;
    }

    public void setCoachCars(List<CoachCar> coachCars) {
        this.coachCars = coachCars;
    }
}
