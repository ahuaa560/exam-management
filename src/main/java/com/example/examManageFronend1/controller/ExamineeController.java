package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import com.example.examManageFronend1.service.UserService;
import org.springframework.web.bind.annotation.*;

import static com.example.examManageFronend1.model.userType.individual;

@RestController
@RequestMapping("/examinee")
public class ExamineeController {

    private final ExamineeService examineeService;
    private final UserService userService;

    public ExamineeController(ExamineeService examineeService, UserService userService) {
        this.examineeService = examineeService;
        this.userService = userService;
    }

    @PostMapping("/")
    public void createExaminee(@RequestParam String password, @RequestBody Examinee examinee) {
        String userId = userService.createUser(password, individual);
        examinee.setUserId(userId);
        examineeService.insertExaminee(examinee);
    }

    @GetMapping("/{userId}")
    public Examinee getExamineeById(@PathVariable String userId) {
        return examineeService.getExamineeById(userId);
    }


    @PutMapping("/")
    public void updateExaminee(@RequestBody Examinee examinee) {
        examineeService.updateExaminee(examinee);
    }

    @DeleteMapping("/{userId}")
    public void deleteExaminee(@PathVariable String userId) {
        examineeService.deleteExaminee(userId);
    }

}
