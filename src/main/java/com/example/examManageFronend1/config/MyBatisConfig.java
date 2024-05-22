package com.example.examManageFronend1.config;

import com.example.examManageFronend1.typehandler.ExamTeacherTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.examManageFronend1.mapper")
public class MyBatisConfig {
    // 注册自定义的 TypeHandler
    @Bean
    public ExamTeacherTypeHandler examTeacherTypeHandler() {
        return new ExamTeacherTypeHandler();
    }
}
