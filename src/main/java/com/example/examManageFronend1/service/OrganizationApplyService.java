package com.example.examManageFronend1.service;

import com.example.examManageFronend1.mapper.*;
import com.example.examManageFronend1.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationApplyService {
    private OrganizationMapper organizationMapper;
    private ExamMapper examMapper;
    private ExamineeMapper examineeMapper;
    private ExamApplyInformationMapper examApplyInformationMapper;
    private RegionMapper regionMapper;
    private ExamCenterMapper examCenterMapper;

    public OrganizationApplyService(OrganizationMapper organizationMapper,ExamMapper examMapper,ExamineeMapper examineeMapper,
                                    ExamApplyInformationMapper examApplyInformationMapper,RegionMapper regionMapper,ExamCenterMapper examCenterMapper) {
        this.organizationMapper = organizationMapper;
        this.examMapper = examMapper;
        this.examineeMapper = examineeMapper;
        this.examApplyInformationMapper = examApplyInformationMapper;
        this.regionMapper=regionMapper;
        this.examCenterMapper=examCenterMapper;
    }

    public Organization getOrganizationByUserId(String userId) {
        return organizationMapper.findByUserId(userId);
    }

    public List<Exam> getExamInfoList() {
        return examMapper.getActiveExams();
    }

    public List<Examinee> getEaxmineeByOrganizationName(String organizationName) {
        return examineeMapper.getExamineesByOrganizationName(organizationName);
    }

    public boolean isApplyExistedByExamIdAndUserId(String examId, String userId) {
        if(examApplyInformationMapper.getExamApplyInformationByUserIdAndExamId(userId, examId) == null) {
            return false;
        }
        return true;
    }

    public Examinee getExamineeByuserId(String userId) {
        return examineeMapper.getExamineeByUserId(Integer.parseInt(userId));
    }

    public Exam getExamByExamId(String examId) {
        return examMapper.getExamByExamId(examId);
    }

    public List<String> getCityNamesByExamId(String examId) {
        return regionMapper.getCityNamesByExamId(examId);
    }


    public ExamCenter getExamCnterByCenterId(String examCenterId) {
        return examCenterMapper.getExamCenterByExamCenterId(examCenterId);
    }

    public Region getRegionByExamCenterId(String examCenterId) {
        String regionId=examCenterMapper.getRegionIdByExamCenterId(examCenterId);
        return regionMapper.getRegionById(regionId);
    }
}
