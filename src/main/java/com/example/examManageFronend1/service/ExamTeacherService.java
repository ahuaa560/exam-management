package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.ExamTeacherMapper;
import com.example.examManageFronend1.model.ExamTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ExamTeacherService.java
@Service
public class ExamTeacherService {
    @Autowired
    private ExamTeacherMapper teacherMapper;

    public ExamTeacher getTeacherByIdNumber(String teacherIdNumber) {
        return teacherMapper.getTeacherByIdNumber(teacherIdNumber);
    }

    public void addTeacher(ExamTeacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    public void updateTeacher(ExamTeacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public void deleteTeacher(String teacherIdNumber) {
        teacherMapper.deleteTeacher(teacherIdNumber);
    }

    public List<ExamTeacher> findAllTeachers() {
        return teacherMapper.findAllTeachers();
    }
}
