package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.ExamApplyInformation;
import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
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
        List<Exam> exams = examineeService.getActiveExams();
        List<ExamApplyInformation> examApplyInfos = examineeService.getExamApplyInformationByUserId(userId);

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
                examInfo.setStatus("未报考");
            } else if (applyInfo.isPaymentStatu()) {
                examInfo.setStatus("已缴费");
            } else {
                examInfo.setStatus("未缴费");
            }

            return examInfo;
        }).collect(Collectors.toList());

        return new ExamineeExamInfo(examinee.getExamineeName(), examInfoList);
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
        private String examineeName;
        private List<ExamInfo> examInfoList;

        // Constructors, getters, setters
        public ExamineeExamInfo(String examineeName, List<ExamInfo> examInfoList) {
            this.examineeName = examineeName;
            this.examInfoList = examInfoList;
        }

        public String getExamineeName() {
            return examineeName;
        }

        public void setExamineeName(String examineeName) {
            this.examineeName = examineeName;
        }

        public List<ExamInfo> getExamInfoList() {
            return examInfoList;
        }

        public void setExamInfoList(List<ExamInfo> examInfoList) {
            this.examInfoList = examInfoList;
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

}
