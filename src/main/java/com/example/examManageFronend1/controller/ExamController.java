package com.example.examManageFronend1.controller;


import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;
    public ExamController(ExamService examService) { this.examService = examService; }

    @GetMapping
    public List<Exam> getAllExam() { return this.examService.getAllExams(); }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable  String id){
        return this.examService.getExamById(id);
    }

    @PostMapping
    public void addExam(@RequestBody Exam exam){ examService.creatExam(exam); }


}
