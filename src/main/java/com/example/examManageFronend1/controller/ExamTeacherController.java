package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.ExamTeacher;
import com.example.examManageFronend1.service.ExamTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class ExamTeacherController {

    @Autowired
    private ExamTeacherService examTeacherService;

    @GetMapping
    public List<ExamTeacher> findAllTeachers() {
        return examTeacherService.findAllTeachers();
    }

    @GetMapping("/{teacherIdNumber}")
    public ExamTeacher findTeacherById(@PathVariable String teacherIdNumber) {
        return examTeacherService.findTeacherById(teacherIdNumber);
    }

    @PutMapping("/update")
    public void updateTeacher(@RequestBody ExamTeacher teacher) {
        examTeacherService.updateTeacher(teacher);
    }
}
