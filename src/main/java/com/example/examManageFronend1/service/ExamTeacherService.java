package com.example.examManageFronend1.service;

import com.example.examManageFronend1.mapper.ExamTeacherMapper;
import com.example.examManageFronend1.model.ExamTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTeacherService {

    @Autowired
    private ExamTeacherMapper examTeacherMapper;

    public List<ExamTeacher> findAllTeachers() {
        System.out.println(examTeacherMapper.findAllTeachers());
        return examTeacherMapper.findAllTeachers();
    }

    public ExamTeacher findTeacherById(String teacherIdNumber) {
        return examTeacherMapper.findTeacherById(teacherIdNumber);
    }

    public void updateTeacher(ExamTeacher teacher) {
        examTeacherMapper.updateTeacher(teacher);
    }
}
