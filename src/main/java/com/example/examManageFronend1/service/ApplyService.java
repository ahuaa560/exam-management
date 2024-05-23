package com.example.examManageFronend1.service;

import com.example.examManageFronend1.algorithm.RandomNineDigitNumber;
import com.example.examManageFronend1.mapper.*;
import com.example.examManageFronend1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApplyService {
    @Autowired
    private ExamineeMapper examineeMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamInformationMapper examInformationMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private ExamCenterMapper examCenterMapper;

    private ExamApplyInformationMapper examApplyInformationMapper;

    private ExamineeNecessaryMapper examineeNecessaryMapper;

    public ApplyService(ExamineeMapper examineeMapper,ExamMapper examMapper,ExamInformationMapper examInformationMapper,RegionMapper regionMapper,ExamCenterMapper examCenterMapper,ExamApplyInformationMapper examApplyInformationMapper,ExamineeNecessaryMapper examineeNecessaryMapper) {
        this.examineeMapper = examineeMapper;
        this.examMapper = examMapper;
        this.examInformationMapper = examInformationMapper;
        this.regionMapper = regionMapper;
        this.examCenterMapper = examCenterMapper;
        this.examApplyInformationMapper = examApplyInformationMapper;
        this.examineeNecessaryMapper = examineeNecessaryMapper;
    }

    public Examinee getExamineeByUserId(String userId) {
        return examineeMapper.getExamineeByUserId(Integer.parseInt(userId));
    }

    public Exam getExamByExamId(String examId) {
        return examMapper.getExamByExamId(examId);
    }

    public List<ExamInformation> getExamInformationByExamId(String examId) {
        return examInformationMapper.getExamInformationByExamId(examId);
    }



    public List<String> findDistrictsByExamIdAndCityName(String examId, String cityName) {
        List<Region>regions = regionMapper.getRegionsByCityName(cityName);
        Set<String> districtsSet = new HashSet<>();
        for (Region region : regions) {
            if (region == null) {
                return null;
            }
            List<ExamCenter> examCenters = examCenterMapper.getExamCentersByRegionId(region.getRegionId());
            for (ExamCenter examCenter : examCenters) {
                boolean flag = false;
                for(String districtName : districtsSet) {
                    if(districtName.equals(region.getDistrictsName())){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    districtsSet.add(region.getDistrictsName());
                }
            }
        }


        List<String> districtsList = new ArrayList<>(districtsSet);

        return districtsList;
    }


    public List<String> getCityNamesByExamId(String examId) {
        return regionMapper.getCityNamesByExamId(examId);
    }

    public Map<String, Object> getExamCenterDetails(String examId, String districtName) {
        Map<String, Object> result = new HashMap<>();

        Region region = regionMapper.getRegionByDistrictName(districtName);
        if (region != null) {
            List<ExamInformation> examInformationList = examInformationMapper.getExamInformationByExamIdAndRegionId(examId, region.getRegionId());
            if (!examInformationList.isEmpty()) {
                List<ExamCenter> examCenters = examCenterMapper.getExamCentersByRegionId(region.getRegionId());
                result.put("examCenters", examCenters);
            }
        }

        return result;
    }

    public int getRemainNumberByExamIdAndCenterId(String examId, String examCenterId) {
        return examInformationMapper.getRemainNumberByExamIdAndCenterId( examId,examCenterId);
    }

    public void addExamExaminee(String examId, String userId, String examCenterId) {
          ExamApplyInformation examApplyInformation = new ExamApplyInformation();

          examApplyInformation.setExamId(examId);
          examApplyInformation.setUser_id(Integer.parseInt(userId));
          examApplyInformation.setExamCenterId(examCenterId);
          examApplyInformation.setPaymentStatu(false);
          examApplyInformation.setExamForm(examMapper.getExamFormByExamId(examId));
          String number;
          do{
            number=RandomNineDigitNumber.generateRandomNineDigitNumber();
          }while (isExamExamineeNumberExists(number));
          examApplyInformation.setExamExamineeNumber(number);

          examApplyInformationMapper.InsertExamApplyInformation(examApplyInformation);

    }

    public String getRegionIdByExamCenterId(String examCenterId) {
        return examCenterMapper.getRegionIdByExamCenterId(examCenterId);
    }

    public Region getRegionByRegionId(String regionId) {
        return regionMapper.getRegionById(regionId);
    }

    public ExamCenter getExamCenterByExamCenterId(String examCenterId) {
        return examCenterMapper.getExamCenterByExamCenterId(examCenterId);
    }

    public void setExamApplyPayed(String userId, String examId) {
        examApplyInformationMapper.setPaymentStatus(userId,examId,true);
    }

    public void updateExamRemainNumber(String examId, String examCenterId, int i) {
        examInformationMapper.updateExamemainNumber(examId,examCenterId,i);
    }


    private boolean isExamExamineeNumberExists(String examNumber) {
        return examApplyInformationMapper.findByExamExamineeNumber(examNumber) != null;
    }

    public ExamApplyInformation getEaxmApplyInformationByUserIdAndExamId(String userId, String examId) {
        return examApplyInformationMapper.getExamApplyInformationByUserIdAndExamId(userId,examId);
    }

    public void addExamineeNecessary(String examExamineeNum, String examineeDemand) {
            examineeNecessaryMapper.addNecessary(examExamineeNum,examineeDemand,false);
    }
}
