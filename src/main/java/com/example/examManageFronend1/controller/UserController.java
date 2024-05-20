package com.example.examManage.controller;

import com.example.examManage.model.User;
import com.example.examManage.model.userType;
import com.example.examManage.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getAccountById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllAccounts() {
        return userService.getAllAccounts();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        user.setUserId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
