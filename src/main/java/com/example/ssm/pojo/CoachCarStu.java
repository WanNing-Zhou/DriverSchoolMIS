package com.example.ssm.pojo;

/**
 * @author 周万宁
 * @className CoachCarStu
 * @create 2023/4/30-22:02
 * @description 学员与车对应表
 */
public class CoachCarStu {
    private int coachCarStuId;
    private int carId;
    private int stuId;

    @Override
    public String toString() {
        return "CoachCarStu{" +
                "coachCarStuId=" + coachCarStuId +
                ", carId=" + carId +
                ", stuId=" + stuId +
                '}';
    }

    public int getCoachCarStuId() {
        return coachCarStuId;
    }

    public void setCoachCarStuId(int coachCarStuId) {
        this.coachCarStuId = coachCarStuId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public CoachCarStu(int coachCarStuId, int carId, int stuId) {
        this.coachCarStuId = coachCarStuId;
        this.carId = carId;
        this.stuId = stuId;
    }

    public CoachCarStu() {
    }
}
