package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.*;
import com.example.examManageFronend1.service.ApplyService;
import com.example.examManageFronend1.service.OrganizationApplyService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduApply")
public class OrganizationApplyController {

    private OrganizationApplyService organizationApplyService;
    private ApplyService applyService;
    public OrganizationApplyController(OrganizationApplyService organizationApplyService,ApplyService applyService) {
        this.organizationApplyService = organizationApplyService;
        this.applyService=applyService;
    }

    @GetMapping("/examInfo")
    Map<String,Object> getExamListByOrganizationId(@RequestParam("userId") String userId){
        Map<String,Object> response = new HashMap<>();
        Organization organization=organizationApplyService.getOrganizationByUserId(userId);
        List<Exam> examInfoList=organizationApplyService.getExamInfoList();

        response.put("examInfoList",examInfoList);
        response.put("organizationName",organization.getOrganizationName());
        response.put("userId",userId);
        response.put("examInfoList",examInfoList);

        return response;
    }

    @GetMapping("/examineeList")
    Map<String,Object> getExamineeListByOrganizationId(@RequestParam("userId") String userId,@RequestParam("examId")String examId){
        Map<String,Object> response = new HashMap<>();
        Organization organization=organizationApplyService.getOrganizationByUserId(userId);
        List<Examinee> examineeList=organizationApplyService.getEaxmineeByOrganizationName(organization.getOrganizationName());

        List<ExamineeInfo> examineeInfoList= new ArrayList<ExamineeInfo>();
        for(Examinee examinee:examineeList){
            boolean status=organizationApplyService.isApplyExistedByExamIdAndUserId(examId,examinee.getUserId());
            ExamineeInfo examineeInfo =new ExamineeInfo(examinee.getExamineeName(),examinee.getExamineePhone(),status,examinee.getUserId());
            examineeInfoList.add(examineeInfo);
        }

        response.put("examineeInfoList",examineeInfoList);
        response.put("examId",examId);
        response.put("organzationUserId",userId);

        return response;
    }

    @PostMapping("/exam")
    Map<String,Object> getExamineeListAndExamInfoByUserIdAndExamId(@RequestBody EduApplyRequest eduApplyRequest){
        Map<String,Object> response = new HashMap<>();
        List<String>userIdList=eduApplyRequest.getUserIdList();
        String examId=eduApplyRequest.getExamId();
        Exam exam=organizationApplyService.getExamByExamId(examId);
        List<String> cityNames = organizationApplyService.getCityNamesByExamId(examId);

        List<Examinee> examineeList=new ArrayList<Examinee>();
        for(String userId:userIdList){
            Examinee examinee =organizationApplyService.getExamineeByuserId(userId);
            examineeList.add(examinee);
        }
        response.put("exam",exam);
        response.put("examinee",examineeList);
        response.put("cityNames",cityNames);



        return response;
    }

    @PostMapping("/commit")
    Map<String,Object> addExamApplication(@RequestBody EduApplyRequest eduApplyRequest){
        Map<String,Object> response=new HashMap<>();
        String examId=eduApplyRequest.getExamId();
        List<String>userIdList=eduApplyRequest.getUserIdList();
        String examCenterId= eduApplyRequest.getExamCenterId();
        Region region=organizationApplyService.getRegionByExamCenterId(examCenterId);

        Exam exam=organizationApplyService.getExamByExamId(examId);
        ExamCenter examCenter=organizationApplyService.getExamCnterByCenterId(examCenterId);
        for(String userId: userIdList){
            applyService.addExamExaminee(examId,userId,examCenterId);
           applyService.updateExamRemainNumber(examId,examCenterId,-1);
        }
        response.put("exam",exam);
        response.put("examCenter",examCenter);
        response.put("userIdList",userIdList);
        response.put("total_payment",exam.getExamPayment()*userIdList.size());
        response.put("region",region);

        return response;
    }


    static class EduApplyRequest{
        List<String> userIdList;
        String examId;
        String examCenterId;

        public EduApplyRequest(List<String> userIdList, String examId ,String examCenterId) {
            this.userIdList = userIdList;
            this.examId = examId;
            this.examCenterId=examCenterId;
        }
        public List<String> getUserIdList() {
            return userIdList;
        }
        public void setUserIdList(List<String> userIdList) {
            this.userIdList = userIdList;
        }
        public String getExamId() {
            return examId;
        }
        public void setExamId(String examId) {
            this.examId = examId;
        }

        public String getExamCenterId() {
            return examCenterId;
        }

        public void setExamCenterId(String examCenterId) {
            this.examCenterId = examCenterId;
        }
    }

    static class ExamineeInfo{
        private String name;
        private String phone;
        boolean applyStatus;
        private String userId;

        public ExamineeInfo(String name, String phone, boolean applyStatus, String userId) {
            this.name = name;
            this.phone = phone;
            this.applyStatus = applyStatus;
            this.userId = userId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public boolean isApplyStatus() {
            return applyStatus;
        }
        public void setApplyStatus(boolean applyStatus) {
            this.applyStatus = applyStatus;
        }
        public String getUserId() {
            return userId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

}
