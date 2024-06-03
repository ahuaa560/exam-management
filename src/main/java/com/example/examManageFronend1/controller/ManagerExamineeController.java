package com.example.examManageFronend1.controller;


import com.example.examManageFronend1.mapper.ExamineeMapper;
import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import com.example.examManageFronend1.service.ManageExamineeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/examinee")
public class ManagerExamineeController {

    @Autowired
    private ManageExamineeService manageExamineeService;

    @GetMapping
    public List<Examinee> getAllExaminee(){
        return manageExamineeService.getAllExaminee();
    }

    @PostMapping("/find")
    public Examinee getExamineeByuserId(@Param("userId") int userId) {
        return manageExamineeService.getExamineeById(userId);
    }
}
