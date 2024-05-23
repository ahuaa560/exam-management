package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.service.ManagerExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manage")
public class ManagerExamController {
    @Autowired
    private ManagerExamService managerExamService;

    @GetMapping("/exam")
    @ResponseBody
    public List<Exam> findAllExams(){
        return managerExamService.getAllExams();
    }

    @PostMapping("/update")
    public void updateApplyTime(@RequestBody Map<String, String> request){
        String examId = request.get("exam_id");
        String timeString = request.get("time");  // 获取时间字符串
        System.out.println(timeString);
        System.out.println(examId);
        if (timeString != null) {
            LocalDateTime time = LocalDateTime.parse(timeString, DateTimeFormatter.ISO_DATE_TIME);
            System.out.println(time);
            managerExamService.updateExam(examId, time);
        } else {
            // 处理时间字符串为空的情况，可以返回错误信息或进行其他处理
        }
    }

    @PostMapping("/create")
    public void addExam(@RequestBody Exam exam){
        managerExamService.createExam(exam);
    }

    @PostMapping("/del")
    public void deleteExam(@RequestParam("examId") String examId){
        managerExamService.deleteExam(examId);
    }

}
