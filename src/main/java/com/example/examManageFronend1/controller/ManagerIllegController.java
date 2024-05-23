package com.example.examManageFronend1.controller;


import com.example.examManageFronend1.model.ManagerIlleg;
import com.example.examManageFronend1.service.ManagerIllegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/illeg")
public class ManagerIllegController {
    @Autowired
    ManagerIllegService managerIllegService;
    @GetMapping
    public List<ManagerIlleg> getAllManagerIlleg() {
        return managerIllegService.findAllManagerIlleg();
    }

    @PostMapping
    public void addManagerIlleg(@RequestBody ManagerIlleg managerIlleg) {
        managerIllegService.addManagerIlleg(managerIlleg);
    }
}
