package com.example.examManageFronend1.service;


import com.example.examManageFronend1.mapper.ExamineeMapper;
import com.example.examManageFronend1.model.Examinee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageExamineeService {
    @Autowired
    private ExamineeMapper examineeMapper;

    public List<Examinee> getAllExaminee(){
        return examineeMapper.findAll();
    }

    public Examinee getExamineeById(int id){
        return examineeMapper.getExamineeByUserId(id);

    }

    public void updateExaminee(Examinee examinee){
        examineeMapper.updateExaminee(examinee);
    }
}
