package com.example.examManageFronend1.service;

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

    public ApplyService(ExamineeMapper examineeMapper,ExamMapper examMapper,ExamInformationMapper examInformationMapper,RegionMapper regionMapper,ExamCenterMapper examCenterMapper) {
        this.examineeMapper = examineeMapper;
        this.examMapper = examMapper;
        this.examInformationMapper = examInformationMapper;
        this.regionMapper = regionMapper;
        this.examCenterMapper = examCenterMapper;
    }

    public Examinee getExamineeByUserId(String userId) {
        return examineeMapper.getExamineeByUserId(userId);
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
}
