package com.example.examManageFronend1.model;

import java.time.LocalDateTime;
import java.util.List;

public class ExamDetail {
    private String examineeName;
    private String examineeIDNumber;
    private String examineePhone;
    private String examName;
    private LocalDateTime startExamTime;
    private LocalDateTime endApplyTime;
    private int examPayment;
    private String cityName;
    private String districtsName;
    private List<ExamCenter> examCenters;

    public ExamDetail(String examineeName, String examineeIDNumber, String examineePhone, String examName,
                      LocalDateTime startExamTime, LocalDateTime endApplyTime, int examPayment,
                      String cityName, String districtsName, List<ExamCenter> examCenters) {
        this.examineeName = examineeName;
        this.examineeIDNumber = examineeIDNumber;
        this.examineePhone = examineePhone;
        this.examName = examName;
        this.startExamTime = startExamTime;
        this.endApplyTime = endApplyTime;
        this.examPayment = examPayment;
        this.cityName = cityName;
        this.districtsName = districtsName;
        this.examCenters = examCenters;
    }

    // getters and setters

    public String getExamineeName() {
        return examineeName;
    }

    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
    }

    public String getExamineeIDNumber() {
        return examineeIDNumber;
    }

    public void setExamineeIDNumber(String examineeIDNumber) {
        this.examineeIDNumber = examineeIDNumber;
    }

    public String getExamineePhone() {
        return examineePhone;
    }

    public void setExamineePhone(String examineePhone) {
        this.examineePhone = examineePhone;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDateTime getStartExamTime() {
        return startExamTime;
    }

    public void setStartExamTime(LocalDateTime startExamTime) {
        this.startExamTime = startExamTime;
    }

    public LocalDateTime getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(LocalDateTime endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public int getExamPayment() {
        return examPayment;
    }

    public void setExamPayment(int examPayment) {
        this.examPayment = examPayment;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictsName() {
        return districtsName;
    }

    public void setDistrictsName(String districtsName) {
        this.districtsName = districtsName;
    }

    public List<ExamCenter> getExamCenters() {
        return examCenters;
    }

    public void setExamCenters(List<ExamCenter> examCenters) {
        this.examCenters = examCenters;
    }
}
