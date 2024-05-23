package com.example.examManageFronend1.service;

import com.example.examManageFronend1.mapper.ExamineeNecessaryMapper;
import com.example.examManageFronend1.model.ExamineeNecessary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeNecessaryService {

    @Autowired
    private ExamineeNecessaryMapper examineeNecessaryMapper;

    public List<ExamineeNecessary> findAllExamineeNecessary() {
        return examineeNecessaryMapper.findAllExamineeNecessary();
    }

    public void updateSolveStatus(ExamineeNecessary examineeNecessary) {
        examineeNecessaryMapper.updateSolveStatus(examineeNecessary);
    }
}
