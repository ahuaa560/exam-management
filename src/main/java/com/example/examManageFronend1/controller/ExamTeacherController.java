package com.example.examManageFronend1.controller;


import com.example.examManageFronend1.model.ExamTeacher;
import com.example.examManageFronend1.service.ManagerService.ExamTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// ExamTeacherController.java
@RestController
@RequestMapping("/teachers")
public class ExamTeacherController {
    @Autowired
    private ExamTeacherService teacherService;

    @GetMapping("/{teacherIdNumber}")
    public ExamTeacher getTeacherByIdNumber(@PathVariable String teacherIdNumber) {
        return teacherService.getTeacherByIdNumber(teacherIdNumber);
    }

    @PostMapping
    public void addTeacher(@RequestBody Map<String, String> request) {
        String teacherIdNumber = request.get("teacher_id_number");
        String teacherName = request.get("teacher_name");

        if (teacherIdNumber != null && teacherName != null) {
            ExamTeacher teacher = new ExamTeacher();
            teacher.setTeacherIdNumber(teacherIdNumber);
            teacher.setTeacherName(teacherName);

            teacherService.addTeacher(teacher);
        } else {
            // 处理参数缺失的情况
            System.out.println("存储失败");
        }
    }

    @PutMapping
    public void updateTeacher(@RequestBody ExamTeacher teacher) {
        teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{teacherIdNumber}")
    public void deleteTeacher(@PathVariable String teacherIdNumber) {
        teacherService.deleteTeacher(teacherIdNumber);
    }

    @GetMapping
    public List<ExamTeacher> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

}
