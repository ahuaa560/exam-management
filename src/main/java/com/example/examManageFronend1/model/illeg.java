package com.example.examManageFronend1.model;

import java.time.LocalDate;

public class illeg {
    String examId;//考试号
    String examCenterId;//考点号
    LocalDate illegalTime;//违规时间
    String illegalInformation;//违规信息

    public void setExamId(String examId) { this.examId = examId; }
    public void setExamCenterId(String examCenterId) { this.examCenterId = examCenterId; }
    public void setIllegalTime(LocalDate illegalTime) { this.illegalTime = illegalTime; }
    public void setIllegalInformation(String illegalInformation) { this.illegalInformation = illegalInformation; }
    public String getExamId() { return examId; }
    public String getExamCenterId() { return examCenterId; }
    public LocalDate getIllegalTime() { return illegalTime; }
    public String getIllegalInformation() { return illegalInformation; }

    @Override
    public String toString() {
        return "illeg [examId=" + examId + ", examCenterId=" + examCenterId
                + ", illegalTime=" + illegalTime + ", illegalInformation=" + illegalInformation
                + "]";
    }
}
