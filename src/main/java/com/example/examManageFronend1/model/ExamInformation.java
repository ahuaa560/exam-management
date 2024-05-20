package com.example.examManage.model;

import java.time.LocalDate;
import java.util.Map;

public class ExamInformation {
    String examCenterId;//考点号
    String examId;//考试号
    LocalDate startExamTime;//考试开始时间
    LocalDate endExamTime;//考试结束时间
    int examRemainNumber;//考点剩余名额
    Map<String, Object> examTeacher;//监考老师


    public void setExamCenterId(String examCenterId) { this.examCenterId = examCenterId; }
    public void setExamId(String examId) { this.examId = examId; }
    public void setStartExamTime(LocalDate startExamTime) { this.startExamTime = startExamTime; }
    public void setEndExamTime(LocalDate endExamTime) { this.endExamTime = endExamTime; }
    public void setExamRemainNumber(int examRemainNumber) { this.examRemainNumber = examRemainNumber; }
    public void setExamTeacher(Map<String, Object> examTeacher) { this.examTeacher = examTeacher; }
    public String getExamCenterId() { return examCenterId; }
    public String getExamId() { return examId; }
    public LocalDate getStartExamTime() { return startExamTime; }
    public LocalDate getEndExamTime() { return endExamTime; }
    public int getExamRemainNumber() { return examRemainNumber; }
    public Map<String, Object> getExamTeacher() { return examTeacher; }

    @Override
    public String toString() {
        return "ExamInformation [examCenterId=" + examCenterId + ", examId=" + examId
                + ", startExamTime=" + startExamTime + ", endExamTime=" + endExamTime
                + ", examRemainNumber=" + examRemainNumber + ", examTeacher="
                + examTeacher + "]";
    }

}
