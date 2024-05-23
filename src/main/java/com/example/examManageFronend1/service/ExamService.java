package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.ExamMapper;
import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final ExamMapper examMapper;

    public ExamService(ExamMapper examMapper) {
        this.examMapper = examMapper;
    }

    public int addExam(Exam exam) { return this.examMapper.insert(exam); }

    public Exam getExamById (String id){
        return examMapper.findById(id);
    }

    public List<Exam> getAllExams(){
        return examMapper.findAll();
    }

    public void deleteExam(String id){
        examMapper.deleteById(id);
    }

    public void creatExam(Exam exam){
        examMapper.insert(exam);
    }


    public void deleteUser(String id) {
        examMapper.deleteById(id);
    }


}
