package com.example.examManageFronend1.model;

import java.time.LocalDateTime;

public class ManagerIlleg {

    String examId;//考试号
    String examCenterId;//考点号
    LocalDateTime illegalTime;//违规时间
    String illegalInformation;//违规信息
    String examName;//考试名
    String examCenterName;//考点名

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamCenterId() {
        return examCenterId;
    }

    public void setExamCenterId(String examCenterId) {
        this.examCenterId = examCenterId;
    }

    public LocalDateTime getIllegalTime() {
        return illegalTime;
    }

    public void setIllegalTime(LocalDateTime illegalTime) {
        this.illegalTime = illegalTime;
    }

    public String getIllegalInformation() {
        return illegalInformation;
    }

    public void setIllegalInformation(String illegalInformation) {
        this.illegalInformation = illegalInformation;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamCenterName() {
        return examCenterName;
    }

    public void setExamCenterName(String examCenterName) {
        this.examCenterName = examCenterName;
    }

    @Override
    public String toString() {
        return "illeg [examId=" + examId + ", examCenterId=" + examCenterId
                + ", illegalTime=" + illegalTime + ", illegalInformation=" + illegalInformation
                + ", examName=" + examName + ", examCenterName=" + examCenterName + "]";
    }

}
