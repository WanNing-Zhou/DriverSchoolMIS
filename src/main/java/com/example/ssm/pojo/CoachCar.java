package com.example.ssm.pojo;

/**
 * @author 周万宁
 * @className CoachCar
 * @create 2023/4/30-22:01
 * @description 教练车pojo
 */
public class CoachCar {

    private int carId;
    private String carBrand;//车品牌
    private String carNumber; //车牌号
    private String carType;//车型
    private String carDesc; //描述

    public CoachCar(int carId, String carBrand, String carNumber, String carType, String carDesc) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carNumber = carNumber;
        this.carType = carType;
        this.carDesc = carDesc;
    }

    public CoachCar() {
    }

    @Override
    public String toString() {
        return "CoachCar{" +
                "carId=" + carId +
                ", carBrand='" + carBrand + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carType='" + carType + '\'' +
                ", carDesc='" + carDesc + '\'' +
                '}';
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }
}
