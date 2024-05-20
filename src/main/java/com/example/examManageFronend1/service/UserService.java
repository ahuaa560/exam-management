package com.example.examManage.service;

import com.example.examManage.mapper.UserMapper;
import com.example.examManage.model.User;
import com.example.examManage.model.userType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(String id) {
        return userMapper.findById(id);
    }

    public List<User> getAllAccounts() {
        return userMapper.findAll();
    }

    public void createUser(User user) {
        userMapper.insert(user);
    }

    public String createUser(String password, userType usertype) {
            User user = new User();
            user.setPassword(password);
            user.setUserType(usertype);
             userMapper.insert(user);
               return user.getUserId();
    }

    public void updateUser(User user) {
        userMapper.update(user);
    }

    public void deleteUser(String id) {
        userMapper.delete(id);
    }
}
