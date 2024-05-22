package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.mapper.ExamMapper;
import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> addExamExaminee(@RequestParam("examId") String examId,@RequestParam("userId") String userId,@RequestParam("centerId") String examCenterId) {
        try{
            applyService.addExamExaminee(examId,userId,examCenterId);
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
