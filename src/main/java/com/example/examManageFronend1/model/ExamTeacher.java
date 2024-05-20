package com.example.examManage.model;

public class ExamTeacher {
    String teacherIdNumber;//监考老师身份证号
    String teacherName;//监考老师姓名

    public void setTeacherIdNumber(String teacherIdNumber) { this.teacherIdNumber = teacherIdNumber; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public String getTeacherIdNumber() { return teacherIdNumber; }
    public String getTeacherName() { return teacherName; }

    @Override
    public String toString() {
        return "ExamTeacher [teacherIdNumber=" + teacherIdNumber
                + ", teacherName=" + teacherName + "]";
    }

}
