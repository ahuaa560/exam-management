package com.example.examManageFronend1.controller;


import com.example.examManageFronend1.model.ExamTeacher;
import com.example.examManageFronend1.service.ExamTeacherService;
import com.example.examManageFronend1.service.ManageExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage/teacher")
public class ManagerExamteacher {
    @Autowired
    private ExamTeacherService ExamTeacherService;

    @GetMapping
    public List<ExamTeacher> getExamTeacher() {
        return ExamTeacherService.findAllTeachers();
    }
}
