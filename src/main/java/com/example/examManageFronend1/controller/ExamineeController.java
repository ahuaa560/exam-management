package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.ExamApplyInformation;
import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/examinee")
public class ExamineeController {

    @Autowired
    private final ExamineeService examineeService;
    //private final UserService userService;




    public ExamineeController(ExamineeService examineeService) {
        this.examineeService = examineeService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createExaminee(@RequestParam String password, @RequestBody Examinee examinee) {
        //String userId = userService.createUser(password, individual);
        //examinee.setUserId(userId);
        try{
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
        private LocalDate startExamTime;
        private LocalDate endExamTime;
        private LocalDate endApplyTime;
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

        public LocalDate getStartExamTime() {
            return startExamTime;
        }

        public void setStartExamTime(LocalDate startExamTime) {
            this.startExamTime = startExamTime;
        }

        public LocalDate getEndExamTime() {
            return endExamTime;
        }

        public void setEndExamTime(LocalDate endExamTime) {
            this.endExamTime = endExamTime;
        }

        public LocalDate getEndApplyTime() {
            return endApplyTime;
        }

        public void setEndApplyTime(LocalDate endApplyTime) {
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
