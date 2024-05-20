package com.example.examManageFronend1.model;

import java.time.LocalDate;

public class Exam {
    String examId;//考试ID
    LocalDate startApplyTime;//开始报名时间
    LocalDate endApplyTime;//结束报名时间
    LocalDate startExamTime;//开始考试时间
    LocalDate endExamTime;//结束考试时间
    int payment;//考试费用
    String examName;//考试名称
    //考试类型
    enum examForm{
        ziKao,
        tongKao

    }
    public String getExamId() { return examId; }
    public void setExamId(String examId) { this.examId = examId; }
    public LocalDate getStartApplyTime() { return startApplyTime; }
    public void setStartApplyTime(LocalDate startApplyTime) { this.startApplyTime = startApplyTime; }
    public LocalDate getEndApplyTime() { return endApplyTime; }
    public void setEndApplyTime(LocalDate endApplyTime) { this.endApplyTime = endApplyTime; }
    public LocalDate getStartExamTime() { return startExamTime; }
    public void setStartExamTime(LocalDate startExamTime) { this.startExamTime = startExamTime; }
    public LocalDate getEndExamTime() { return endExamTime; }
    public void setEndExamTime(LocalDate endExamTime) { this.endExamTime = endExamTime; }
    public int getPayment() { return payment; }
    public void setPayment(int payment) { this.payment = payment; }
    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", startApplyTime=" + startApplyTime
                + ", endApplyTime=" + endApplyTime + ", startExamTime=" + startExamTime
                + ", endExamTime=" + endExamTime + ", payment=" + payment + ", examName="
                + examName + "]";

    }
}


