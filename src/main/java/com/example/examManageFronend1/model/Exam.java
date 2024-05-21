package com.example.examManageFronend1.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Exam {
    public LocalDate getStartExamTime() {
        return startExamTime;
    }

    public void setStartExamTime(LocalDate startExamTime) {
        this.startExamTime = startExamTime;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public LocalDate getStartApplyTime() {
        return startApplyTime;
    }

    public void setStartApplyTime(LocalDate startApplyTime) {
        this.startApplyTime = startApplyTime;
    }

    public LocalDate getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(LocalDate endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public LocalDate getEndExamTime() {
        return endExamTime;
    }

    public void setEndExamTime(LocalDate endExamTime) {
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
    private LocalDate startApplyTime; // 开始报名时间
    private LocalDate endApplyTime; // 结束报名时间
    private LocalDate startExamTime; // 开始考试时间
    private LocalDate endExamTime; // 结束考试时间
    private int examPayment; // 考试费用
    private String examName; // 考试名称
    private ExamForm examForm; // 考试类型

    // 考试类型枚举
    public enum ExamForm {
        SHENGKAO, // 省考
        TONGKAO // 统考
    }

    @Override
    public String toString() {
        return "Exam [examId=" + examId + ", startApplyTime=" + startApplyTime
                + ", endApplyTime=" + endApplyTime + ", startExamTime=" + startExamTime
                + ", endExamTime=" + endExamTime + ", examPayment=" + examPayment + ", examName="
                + examName + ", examForm=" + examForm + "]";
    }
}


