package com.example.examManageFronend1.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // http://localhost:8080/hello
    // http://localhost:8080/hello?nickname=zhangsan
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String nickname) {
        return "hello world"+nickname;
    }
}
