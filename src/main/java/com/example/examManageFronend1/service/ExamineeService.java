package com.example.examManageFronend1.service;

import com.example.examManageFronend1.mapper.ExamApplyInformationMapper;
import com.example.examManageFronend1.mapper.ExamMapper;
import com.example.examManageFronend1.mapper.ExamineeMapper;
import com.example.examManageFronend1.mapper.UserMapper;
import com.example.examManageFronend1.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeService {

    private final ExamineeMapper examineeMapper;
    private final UserMapper userMapper;
    private final ExamApplyInformationMapper examApplyInformationMapper;
    private final ExamMapper examMapper;

    public ExamineeService(ExamineeMapper examineeMapper, UserMapper userMapper, ExamApplyInformationMapper examApplyInformationMapper, ExamMapper examMapper) {
        this.examineeMapper = examineeMapper;
        this.userMapper = userMapper;
        this.examApplyInformationMapper = examApplyInformationMapper;
        this.examMapper = examMapper;
    }
    public List<Examinee> getAllExaminee() {
        return examineeMapper.findAll();
    }
    public void insertExaminee(String password,Examinee examinee) throws Exception {

        // 检查身份证是否已存在
        if (examineeMapper.countByIdCard(examinee.getExamineeIDNumber()) > 0) {
            throw new Exception("身份证已存在");
        }
        // 检查手机号是否已存在
        if (examineeMapper.countByPhoneNumber(examinee.getExamineePhone()) > 0) {
            throw new Exception("手机号已存在");
        }
        // 检查邮箱是否已存在
        if (examineeMapper.countByEmail(examinee.getExamineeEmail()) > 0) {
            throw new Exception("邮箱已存在");
        }

        //先创建用户
        User user = new User();
        user.setPassword(password);
        user.setUserType(userType.individual);
        userMapper.insert(user);
        examinee.setUserId(user.getUserId());
        System.out.println("userId:"+user.getUserId());

        examinee.setWhiteListed(true);

        examineeMapper.insertExaminee(examinee);
    }


    public Examinee getExamineeByUserId(String userId) {
        return examineeMapper.getExamineeByUserId(userId);
    }

    public void updateExaminee(Examinee examinee) {
        examineeMapper.updateExaminee(examinee);
    }

    public void deleteExaminee(String userId) {
        examineeMapper.deleteExaminee(userId);
    }

    public Examinee findByIdNumberOrEmailOrPhone(String idNumber, String email, String phone) {
        return examineeMapper.findByIdNumberOrEmailOrPhone(idNumber, email, phone);
    }

    public List<Exam> getActiveExams() {
        return examMapper.getActiveExams();
    }

    public List<ExamApplyInformation> getExamApplyInformationByUserId(String userId) {
        return examApplyInformationMapper.getExamApplyInformationByUserId(userId);
    }


}
