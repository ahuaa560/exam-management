package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.ExamMapper;
import com.example.examManageFronend1.model.Exam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManagerExamService {
    private final ExamMapper examMapper;

    public ManagerExamService(@Qualifier("examMapper") ExamMapper examMapper) {
        this.examMapper = examMapper;
    }

    public List<Exam> getAllExams(){
        return examMapper.findAll();
    }

    public void updateExam(String id , LocalDateTime time){
        examMapper.updateEndApplyTimeToNewTime(id, time);
    }

    public void createExam(Exam exam){
        examMapper.insert(exam);
    }

    public void deleteExam(String examId){
        examMapper.deleteById(examId);
    }

}
