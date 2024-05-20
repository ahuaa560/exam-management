package com.example.examManageFronend1.service;

import com.example.examManageFronend1.algorithm.RandomNineDigitNumber;
import com.example.examManageFronend1.mapper.ExamineeMapper;
import com.example.examManageFronend1.model.Examinee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeService {

    private final ExamineeMapper examineeMapper;
    public ExamineeService(ExamineeMapper examineeMapper) {
        this.examineeMapper = examineeMapper;
    }
    public List<Examinee> getAllExaminee() {
        return examineeMapper.findAll();
    }
     public void insertExaminee(Examinee examinee) {

        RandomNineDigitNumber randomNineDigitNumber=new RandomNineDigitNumber();
        examinee.setExamineeIDNumber(randomNineDigitNumber.generateRandomNineDigitNumber());
        examinee.setWhiteListed(true);
        examineeMapper.insertExaminee(examinee);
    }

    public Examinee getExamineeById(String userId) {
        return examineeMapper.getExamineeById(userId);
    }

    public void updateExaminee(Examinee examinee) {
        examineeMapper.updateExaminee(examinee);
    }

    public void deleteExaminee(String userId) {
        examineeMapper.deleteExaminee(userId);
    }
}
