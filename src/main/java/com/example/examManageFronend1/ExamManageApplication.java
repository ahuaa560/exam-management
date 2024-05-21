package com.example.examManageFronend1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.examManageFronend1.mapper")
@SpringBootApplication
public class ExamManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamManageApplication.class, args);
	}

}
