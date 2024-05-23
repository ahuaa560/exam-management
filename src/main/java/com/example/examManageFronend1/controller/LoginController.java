package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.model.LoginRequest;
import com.example.examManageFronend1.model.Organization;
import com.example.examManageFronend1.model.User;
import com.example.examManageFronend1.service.ExamineeService;
import com.example.examManageFronend1.service.OrganizationService;
import com.example.examManageFronend1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String identifier = loginRequest.getIdentifier();
        String password = loginRequest.getPassword();
        String usertype = loginRequest.getUsertype();

   //考生
        if (Objects.equals(usertype, "individual")) {
            Examinee examinee;
            try {
                examinee = examineeService.findByIdNumberOrEmailOrPhone(identifier, identifier, identifier);
                System.out.println(examinee.toString());
            } catch (NoSuchElementException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该考生");
            }

            User user = userService.findByUserId(examinee.getUserId());
            if (user != null && user.getPassword().equals(password)) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("success", true);
                responseBody.put("message", "Login successful!");
                responseBody.put("userId", user.getUserId());
                return ResponseEntity.ok(responseBody);
            } else {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("success", false);
                responseBody.put("error", "Login failed. Invalid username or password.");
                responseBody.put("userId", null);
                return ResponseEntity.badRequest().body(responseBody);
            }
            //机构
        } else if (Objects.equals(usertype, "edu")) {
            Organization organization = organizationService.findByUserId(identifier);
            if (organization == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("找不到该机构");
            }
            User user = userService.findByUserId(identifier);
            if (user != null && user.getPassword().equals(password)) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("success", true);
                responseBody.put("message", "Login successful!");
                responseBody.put("userId", user.getUserId());
                responseBody.put("organizationNumber", organization.getOrganizationNumber());
                responseBody.put("organizationName", organization.getOrganizationName());
                return ResponseEntity.ok(responseBody);
                //return ResponseEntity.ok("Login successful,机构id:" + organization.getOrganizationNumber() + ",机构名称:" + organization.getOrganizationName());
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

                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("success", true);
                responseBody.put("message", "Login successful!");
                responseBody.put("userId", user.getUserId());
                return ResponseEntity.ok(responseBody);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }
    }
}

