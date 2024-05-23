package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.ExamApplyInformation;
import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/examinee")
public class ExamineeController {

    @Autowired
    private final ExamineeService examineeService;




    public ExamineeController(ExamineeService examineeService) {
        this.examineeService = examineeService;
    }

    //考生注册
    @PostMapping("")
    public ResponseEntity<?> createExaminee(@RequestBody ExamineeInfo examineeInfo) {
        try{
            Examinee examinee=new Examinee();
            String password= examineeInfo.getPassword();
            examinee.setExamineeEmail(examineeInfo.getExamineeEmail());
            examinee.setExamineePhone(examineeInfo.getExamineePhone());
            examinee.setExamineeName(examineeInfo.getExamineeName());
            examinee.setExamineeIDNumber(examineeInfo.getExamineeIDNumber());
            examineeService.insertExaminee(password,examinee);
            return ResponseEntity.ok("create examinee successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{userId}")
    public Examinee getExamineeByUserId(@PathVariable String userId) {
        return examineeService.getExamineeByUserId(userId);
    }

    @GetMapping("/info")
    public Map<String,Object> getExamineeInfoByUserId(@Param("userId") String userId){
        Examinee examinee=examineeService.getExamineeByUserId(userId);
        Map<String,Object> response=new HashMap<>();
        Map<String,Object> examineeInfo=new HashMap<>();

        examineeInfo.put("name",examinee.getExamineeName());
        examineeInfo.put("IDNumber",examinee.getExamineeIDNumber());
        examineeInfo.put("email",examinee.getExamineeEmail());
        examineeInfo.put("phone",examinee.getExamineePhone());
        examineeInfo.put("userId",examinee.getUserId());
        response.put("examinee",examineeInfo);
        return response;
    }


    @PutMapping("/")
    public void updateExaminee(@RequestBody Examinee examinee) {
        examineeService.updateExaminee(examinee);
    }

    @DeleteMapping("/{userId}")
    public void deleteExaminee(@PathVariable String userId) {
        examineeService.deleteExaminee(userId);
    }

    //主报名界面
    @GetMapping("/exam/{userId}")
    public ExamineeExamInfo getExamineeExamInfo(@PathVariable String userId) {
        Examinee examinee = examineeService.getExamineeByUserId(userId);
        String examineeName = examinee.getExamineeName();
        List<Exam> exams = examineeService.getActiveExams();
        List<ExamApplyInformation> examApplyInfos = examineeService.getExamApplyInformationByUserId(userId);

        UserInfo userInfo = new UserInfo(examineeName, examinee.getUserId(),"individual");

        List<ExamInfo> examInfoList = exams.stream().map(exam -> {
            ExamInfo examInfo = new ExamInfo();
            examInfo.setExamId(exam.getExamId());
            examInfo.setExamName(exam.getExamName());
            examInfo.setStartExamTime(exam.getStartExamTime());
            examInfo.setEndExamTime(exam.getEndExamTime());
            examInfo.setEndApplyTime(exam.getEndApplyTime());

            ExamApplyInformation applyInfo = examApplyInfos.stream()
                    .filter(info -> info.getExamId().equals(exam.getExamId()))
                    .findFirst()
                    .orElse(null);

            if (applyInfo == null) {
                examInfo.setStatus("not_selected");
            } else if (applyInfo.isPaymentStatu()) {
                examInfo.setStatus("selected");
            } else {
                examInfo.setStatus("completed");
            }

            return examInfo;
        }).collect(Collectors.toList());

        return new ExamineeExamInfo(userInfo, examInfoList);
    }


    static class ExamineeInfo{


        String examineeName;//数据库：examinee_name
        String examineeIDNumber;//数据库：examinee_ID_number
        String examineeEmail;//数据库：examinee_email
        String examineePhone;//数据库：examinee_phone
        String password;

        public String getExamineeEmail() {
            return examineeEmail;
        }
        public String getExamineePhone() {
            return examineePhone;
        }
        public String getPassword() {
            return password;
        }
        public String getExamineeName() {
            return examineeName;
        }

        public String getExamineeIDNumber() {
            return examineeIDNumber;
        }
    }

    static class ExamineeExamInfo {
        private UserInfo userInfoList;
        private List<ExamInfo> examInfoList;

        // Constructors, getters, setters
        public ExamineeExamInfo(UserInfo userInfoList, List<ExamInfo> examInfoList) {
            this.userInfoList=userInfoList;
            this.examInfoList = examInfoList;
        }



        public List<ExamInfo> getExamInfoList() {
            return examInfoList;
        }

        public void setExamInfoList(List<ExamInfo> examInfoList) {
            this.examInfoList = examInfoList;
        }

        public UserInfo getUserInfoList() {
            return userInfoList;
        }

        public void setUserInfoList(UserInfo userInfoList) {
            this.userInfoList = userInfoList;
        }
    }

    static class ExamInfo {

        private String examId;
        private String examName;
        private LocalDateTime startExamTime;
        private LocalDateTime endExamTime;
        private LocalDateTime endApplyTime;
        private String status;

        // Constructors, getters, setters
        public String getExamId() {
            return examId;
        }

        public void setExamId(String examId) {
            this.examId = examId;
        }
        public String getExamName() {
            return examName;
        }

        public void setExamName(String examName) {
            this.examName = examName;
        }

        public LocalDateTime getStartExamTime() {
            return startExamTime;
        }

        public void setStartExamTime(LocalDateTime startExamTime) {
            this.startExamTime = startExamTime;
        }

        public LocalDateTime getEndExamTime() {
            return endExamTime;
        }

        public void setEndExamTime(LocalDateTime endExamTime) {
            this.endExamTime = endExamTime;
        }

        public LocalDateTime getEndApplyTime() {
            return endApplyTime;
        }

        public void setEndApplyTime(LocalDateTime endApplyTime) {
            this.endApplyTime = endApplyTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    static class UserInfo {
        private String name;
        private String userId;
        private String user_type;

        public UserInfo(String name, String userId,String user_type) {
            this.name = name;
            this.userId = userId;
            this.user_type = user_type;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUser_type() {
            return user_type;
        }
        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }
        public String getUser_id() {
            return userId;
        }
        public void setUser_id(String user_id) {
            this.userId = user_id;
        }
    }

}
