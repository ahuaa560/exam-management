package com.example.examManageFronend1.service.ManagerService;

import com.example.examManageFronend1.mapper.ExamCenterMapper;
import com.example.examManageFronend1.model.ExamCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamCenterService {

    @Autowired
    private ExamCenterMapper examCenterMapper;

    public ExamCenter getExamCenterById(String examCenterId) {
        return examCenterMapper.selectExamCenterById(examCenterId);
    }

    public List<ExamCenter> getAllExamCenters() {
        return examCenterMapper.selectAllExamCenters();
    }

    public void addExamCenter(ExamCenter examCenter) {
        examCenterMapper.insertExamCenter(examCenter);
    }

    public void updateExamCenter(ExamCenter examCenter) {
        examCenterMapper.updateExamCenter(examCenter);
    }

    public void deleteExamCenter(String examCenterId) {
        examCenterMapper.deleteExamCenter(examCenterId);
    }
}