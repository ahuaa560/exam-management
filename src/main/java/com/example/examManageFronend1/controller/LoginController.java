package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.model.Organization;
import com.example.examManageFronend1.model.User;
import com.example.examManageFronend1.model.userType;
import com.example.examManageFronend1.service.ExamineeService;
import com.example.examManageFronend1.service.OrganizationService;
import com.example.examManageFronend1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("")
    ResponseEntity<?> login(@RequestParam String identifier, @RequestParam String password, @RequestParam userType usertype) {
   //考生
        if (usertype == userType.individual) {
            try {
                Examinee examinee = examineeService.findByIdNumberOrEmailOrPhone(identifier, identifier, identifier);
                System.out.println(examinee.toString());
            } catch (NoSuchElementException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该考生");
            }


            User user = userService.findByUserId(examinee.getUserId());
            if (user != null && user.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful,考生id:" + examinee.getUserId());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
            //机构
        } else if (usertype == userType.edu) {
            Organization organization = organizationService.findByUserId(identifier);
            if (organization == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("找不到该机构");
            }
            User user = userService.findByUserId(identifier);
            if (user != null && user.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful,机构id:" + organization.getOrganizationNumber() + ",机构名称:" + organization.getOrganizationName());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
            //管理员
        } else {
            User user = userService.findByUserId(identifier);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("该账号不存在");
            }
            if (user != null && user.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful,管理员id:" + user.getUserId());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }
    }
}

