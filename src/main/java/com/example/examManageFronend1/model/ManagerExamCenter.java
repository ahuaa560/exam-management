package com.example.examManageFronend1.model;

import java.time.LocalDateTime;
import java.util.Map;

public class ManagerExamCenter {
    public String getExamCenterId() {
        return examCenterId;
    }

    public void setExamCenterId(String examCenterId) {
        this.examCenterId = examCenterId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public LocalDateTime getStartExamTime() {
        return startExamTime;
    }

    public void setStartExamTime(LocalDateTime startExamTime) {
        this.startExamTime = startExamTime;
    }

    public LocalDateTime getEndExamTime() {
        return endExamTime;
    }

    public void setEndExamTime(LocalDateTime endExamTime) {
        this.endExamTime = endExamTime;
    }

    public int getExamRemainNumber() {
        return examRemainNumber;
    }

    public void setExamRemainNumber(int examRemainNumber) {
        this.examRemainNumber = examRemainNumber;
    }

    public Map<String, Object> getExamTeacher() {
        return examTeacher;
    }

    public void setExamTeacher(Map<String, Object> examTeacher) {
        this.examTeacher = examTeacher;
    }

    public String getExamCenterName() {
        return examCenterName;
    }

    public void setExamCenterName(String examCenterName) {
        this.examCenterName = examCenterName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getDistrictsName() {
        return districtsName;
    }

    public void setDistrictsName(String districtsName) {
        this.districtsName = districtsName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getExamCenterLocation() {
        return examCenterLocation;
    }

    public void setExamCenterLocation(String examCenterLocation) {
        this.examCenterLocation = examCenterLocation;
    }

    String examCenterId;//考点号
    String examCenterName;//考点名
    String regionId;//区域号
    String examCenterLocation;//考点地址
    String districtsName;//县级名
    String cityName;//市级名
    String examId;//考试号
    LocalDateTime startExamTime;//考试开始时间
    LocalDateTime endExamTime;//考试结束时间
    int examRemainNumber;//考点剩余名额
    Map<String, Object> examTeacher;//监考老师
}
