package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.mapper.ExamMapper;
import com.example.examManageFronend1.model.*;
import com.example.examManageFronend1.service.ApplyService;
import com.example.examManageFronend1.service.RegionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    private final ExamMapper examMapper;
    @Autowired
    private RegionService regionService;

    @Autowired
    public ApplyController(ExamMapper examMapper) {
        this.examMapper = examMapper;
    }

    @GetMapping("/info")
    public Map<String, Object> getExamInfo(@RequestParam String userId, @RequestParam String examId) {
        Examinee examinee = applyService.getExamineeByUserId(userId);
        Exam exam = applyService.getExamByExamId(examId);
        List<String> cityNames = applyService.getCityNamesByExamId(examId);


        Map<String, Object> response = new HashMap<>();
        response.put("examineeName", examinee.getExamineeName());
        response.put("examineeIDNumber", examinee.getExamineeIDNumber());
        response.put("examineePhone", examinee.getExamineePhone());
        response.put("examName", exam.getExamName());
        response.put("startExamTime", exam.getStartExamTime());
        response.put("endExamTime", exam.getEndExamTime());
        response.put("endApplyTime", exam.getEndApplyTime());
        response.put("examPayment", exam.getExamPayment());
        response.put("cityNames", cityNames);
        response.put("examId", exam.getExamId());


        return response;
    }
    @GetMapping("/districts")
    public List<String> getDistrictsByExamIdAndCityName(@RequestParam String examId, @RequestParam String cityName) {
        return applyService.findDistrictsByExamIdAndCityName(examId, cityName);
    }

    @GetMapping("/examCenter")
    public Map<String, Object> getExamCenterDetails(@RequestParam("examId") String examId, @RequestParam("districtName") String districtName) {
        return applyService.getExamCenterDetails(examId, districtName);
    }

    @GetMapping("/remainNumber")
    public int getRemainNumberByExamIdAndCenterId(@RequestParam("examId") String examId, @RequestParam("centerId") String examCenterId) {

        return applyService.getRemainNumberByExamIdAndCenterId(examId, examCenterId);

    }

    @PostMapping("/exam")
    public Map<String,Object> addExamExaminee(@RequestParam("examId") String examId,@RequestParam("userId") String userId,@RequestParam("centerId") String examCenterId) {
        Map<String,Object>response = new HashMap<>();

            if(applyService.getEaxmApplyInformationByUserIdAndExamId(userId,examId)!=null)
            {
                response.put("success",false);
                response.put("error","考生已报名该考试");
                return response;
            }
            applyService.addExamExaminee(examId,userId,examCenterId);
            applyService.updateExamRemainNumber(examId,examCenterId,-1);


            Exam exam = applyService.getExamByExamId(examId);
            ExamCenter examCenter=applyService.getExamCenterByExamCenterId(examCenterId);
            String regionId=applyService.getRegionIdByExamCenterId(examCenterId);
            Region region=applyService.getRegionByRegionId(regionId);

            response.put("examId", examId);
            response.put("examCenterId", examCenterId);
            response.put("userId", userId);
            response.put("examName", exam.getExamName());
            response.put("startExamTime", exam.getStartExamTime());
            response.put("endExamTime", exam.getEndExamTime());
            response.put("examPayment", exam.getExamPayment());
            response.put("cityName", region.getCityName());
            response.put("districtName",region.getDistrictsName());
            response.put("centerName",examCenter.getExamCenterName());
            response.put("centerLocation", examCenter.getExamCenterLocation());

            return response;
    }

    //考生支付
    @PostMapping("/pay")
    public Map<String,Object> SetExamApplyPayed(@Param("userId")String userId,@Param("examId")String examId){

        try{
            applyService.setExamApplyPayed(userId,examId);

            Examinee examinee=applyService.getExamineeByUserId(userId);
            Map<String,Object>examineeMap=new HashMap<>();
            examineeMap.put("userId", userId);
            examineeMap.put("examineeName", examinee.getExamineeName());

            Exam exam=applyService.getExamByExamId(examId);
            Map<String,Object>examMap=new HashMap<>();
            examMap.put("examId", exam.getExamId());
            examMap.put("examName", exam.getExamName());
            examMap.put("startExamTime", exam.getStartExamTime());
            examMap.put("endAppllyTime", exam.getEndApplyTime());

            Map<String,Object>response = new HashMap<>();
            response.put("examinee", examineeMap);
            response.put("exam", examMap);

            return response;
        }
        catch (Exception e){
            Map<String,Object>response = new HashMap<>();
            e.printStackTrace();
            response.put("error",e.getMessage());
            return response;
        }
    }

    @GetMapping("/necessary")
    Map<String,Object> getInfoBeforeNeccessaryExam(@RequestParam("examId") String examId,@RequestParam("userId") String userId) {
        Map<String,Object>response = new HashMap<>();

        ExamApplyInformation examApplyInformation =applyService.getEaxmApplyInformationByUserIdAndExamId(userId,examId);
        Exam exam=applyService.getExamByExamId(examId);
        ExamCenter examCenter=applyService.getExamCenterByExamCenterId(examApplyInformation.getExamCenterId());
        Region region=applyService.getRegionByRegionId(examCenter.getRegionId());


        Map<String,Object>examMap=new HashMap<>();
        examMap.put("Id", exam.getExamId());
        examMap.put("name", exam.getExamName());
        examMap.put("startExamTime", exam.getStartExamTime());
        examMap.put("endExamTime", exam.getEndExamTime());

        Map<String,Object>examCenterMap=new HashMap<>();
        examCenterMap.put("Id", examCenter.getExamCenterId());
        examCenterMap.put("centerName", examCenter.getExamCenterName());
        examCenterMap.put("centerLocation",examCenter.getExamCenterLocation());
        examCenterMap.put("cityName", region.getCityName());
        examCenterMap.put("districtName", region.getDistrictsName());

        response.put("userId", userId);
        response.put("examExamineeNumber", examApplyInformation.getExamExamineeNumber());
        response.put("exam",examMap);
        response.put("examCenter",examCenterMap);

        return response;
    }


}
