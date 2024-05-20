package com.example.examManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.examManage.mapper")
@SpringBootApplication
public class ExamManageFronend1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExamManageFronend1Application.class, args);
	}

}
