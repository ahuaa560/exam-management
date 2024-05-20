package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.service.ExamineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/examinee")
public class ExamineeController {

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
