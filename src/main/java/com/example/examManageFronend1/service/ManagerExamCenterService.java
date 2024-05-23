package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.ManagerExamCenterMapper;
import com.example.examManageFronend1.model.ManagerExamCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerExamCenterService {
    @Autowired
    private ManagerExamCenterMapper managerExamCenterMapper;

    public List<ManagerExamCenter> getExamCenter() {
        return managerExamCenterMapper.findAllExamCenters();
    }

    public void addExamCenter(ManagerExamCenter examCenter) {
       managerExamCenterMapper.manageAddExamCenter(examCenter);
    }

    public void updateExamCenter(ManagerExamCenter examCenter) {
        managerExamCenterMapper.manageUpdateExamCenter(examCenter);
    }

    public void deleteExamCenter(String examCenterId) {
        managerExamCenterMapper.manageDeleteExamCenter(examCenterId);
    }
}
