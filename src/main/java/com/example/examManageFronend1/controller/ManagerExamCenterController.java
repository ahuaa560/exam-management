package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.ManagerExamCenter;
import com.example.examManageFronend1.service.ManagerExamCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/examCenter")
public class ManagerExamCenterController {

    @Autowired
    private ManagerExamCenterService managerExamCenterService;

    @GetMapping
    public List<ManagerExamCenter> getManagerExamCenter() {
        return managerExamCenterService.getExamCenter();
    }

    @PostMapping("/update")
    public void updateManagerExamCenter(@RequestBody ManagerExamCenter managerExamCenter) {
        managerExamCenterService.updateExamCenter(managerExamCenter);
    }

    @PostMapping("/{id}")
    public ManagerExamCenter getManagerExamCenter(@PathVariable String id) {
        return managerExamCenterService.getExamCenterById(id);
    }

}
