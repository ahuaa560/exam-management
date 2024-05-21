package com.example.examManageFronend1.controller;

import com.example.examManageFronend1.model.Examinee;
import com.example.examManageFronend1.model.Organization;
import com.example.examManageFronend1.model.User;
import com.example.examManageFronend1.model.userType;
import com.example.examManageFronend1.service.ExamineeService;
import com.example.examManageFronend1.service.OrganizationService;
import com.example.examManageFronend1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/examinee")
    public String login(@RequestParam String identifier, @RequestParam String password) {
        Examinee examinee = examineeService.findByIdNumberOrEmailOrPhone(identifier, identifier, identifier);
        if (examinee == null) {
            return "未找到该考生";
        }

        User user = userService.findByUserId(examinee.getUserId());
        if (user != null && user.getPassword().equals(password)) {
            return "Login successful,考生id:"+examinee.getUserId();
        } else {
            return "Invalid credentials";
        }
    }

    @PostMapping("/")
    public String login(@RequestParam String userId,@RequestParam String password,@RequestParam userType usertype){
        if(usertype==userType.edu){
            Organization organization= organizationService.findByUserId(userId);
            if(organization == null)
            {
                return "找不到该机构";
            }
            User user=userService.findByUserId(userId);
            if (user != null && user.getPassword().equals(password)) {

                return "Login successful,机构id:"+organization.getOrganizationNumber()+",机构名称:"+organization.getOrganizationName();
            } else {
                return "Invalid credentials";
            }

        }
        else
        {
            User user=userService.findByUserId(userId);
            if (user == null) {
                return "该账号不存在";
            }
            if (user != null && user.getPassword().equals(password)) {

                return "Login successful,管理员id:"+user.getUserId();
            } else {
                return "Invalid credentials";
            }
        }
    }
}
