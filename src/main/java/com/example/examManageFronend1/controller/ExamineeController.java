package com.example.examManage.controller;

import com.example.examManage.model.Examinee;
import com.example.examManage.model.User;
import com.example.examManage.service.ExamineeService;
import com.example.examManage.service.UserService;
import org.springframework.web.bind.annotation.*;

import static com.example.examManage.model.userType.individual;

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
