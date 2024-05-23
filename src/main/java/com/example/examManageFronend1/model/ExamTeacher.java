package com.example.examManageFronend1.model;

public class ExamTeacher {
    String teacherIdNumber;//监考老师身份证号

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIdNumber() {
        return teacherIdNumber;
    }

    public void setTeacherIdNumber(String teacherIdNumber) {
        this.teacherIdNumber = teacherIdNumber;
    }

    String teacherName;//监考老师姓名



    @Override
    public String toString() {
        return "ExamTeacher [teacherIdNumber=" + teacherIdNumber
                + ", teacherName=" + teacherName + "]";
    }

}
