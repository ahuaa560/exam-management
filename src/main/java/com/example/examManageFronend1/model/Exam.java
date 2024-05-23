package com.example.examManageFronend1.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Exam {
    public LocalDateTime getStartExamTime() {
        return startExamTime;
    }

    public void setStartExamTime(LocalDateTime startExamTime) {
        this.startExamTime = startExamTime;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public LocalDateTime getStartApplyTime() {
        return startApplyTime;
    }

    public void setStartApplyTime(LocalDateTime startApplyTime) {
        this.startApplyTime = startApplyTime;
    }

    public LocalDateTime getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(LocalDateTime endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public LocalDateTime getEndExamTime() {
        return endExamTime;
    }

    public void setEndExamTime(LocalDateTime endExamTime) {
        this.endExamTime = endExamTime;
    }

    public int getExamPayment() {
        return examPayment;
    }

    public void setExamPayment(int examPayment) {
        this.examPayment = examPayment;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public ExamForm getExamForm() {
        return examForm;
    }

    public void setExamForm(ExamForm examForm) {
        this.examForm = examForm;
    }

    private String examId; // 考试ID
    private LocalDateTime startApplyTime; // 开始报名时间
    private LocalDateTime endApplyTime; // 结束报名时间
    private LocalDateTime startExamTime; // 开始考试时间
    private LocalDateTime endExamTime; // 结束考试时间
    private int examPayment; // 考试费用
    private String examName; // 考试名称
    private ExamForm examForm; // 考试类型


    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", startApplyTime=" + startApplyTime
                + ", endApplyTime=" + endApplyTime + ", startExamTime=" + startExamTime
                + ", endExamTime=" + endExamTime + ", examPayment=" + examPayment + ", examName="
                + examName + ", examForm=" + examForm + "]";
    }
}


