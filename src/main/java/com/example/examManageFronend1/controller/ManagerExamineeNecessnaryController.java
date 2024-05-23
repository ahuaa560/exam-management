package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.ExamineeNecessary;
import com.example.examManageFronend1.service.ExamineeNecessaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examinees/necessary")
public class ManagerExamineeNecessnaryController {

    @Autowired
    private ExamineeNecessaryService examineeNecessaryService;

    @GetMapping
    public List<ExamineeNecessary> findAllExamineeNecessary() {
        return examineeNecessaryService.findAllExamineeNecessary();
    }

    @PutMapping("/updateSolveStatus")
    public void updateSolveStatus(@RequestBody ExamineeNecessary examineeNecessary) {
        examineeNecessaryService.updateSolveStatus(examineeNecessary);
    }
}
