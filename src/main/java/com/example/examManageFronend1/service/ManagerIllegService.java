package com.example.examManageFronend1.service;

import com.example.examManageFronend1.mapper.ManagerIllegMapper;
import com.example.examManageFronend1.model.ManagerIlleg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerIllegService {
    @Autowired
    private ManagerIllegMapper managerIllegMapper;
    

    public List<ManagerIlleg> findAllManagerIlleg() {
        return managerIllegMapper.findAllManagerIlleg();
    }

    public void addManagerIlleg(ManagerIlleg managerIlleg) {
        managerIllegMapper.addManagerIlleg(managerIlleg);
    }
}
