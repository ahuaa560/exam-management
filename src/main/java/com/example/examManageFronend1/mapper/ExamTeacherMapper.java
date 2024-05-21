package com.example.examManageFronend1.mapper;


import com.example.examManageFronend1.model.ExamTeacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

// ExamTeacherMapper.java
@Mapper
public interface ExamTeacherMapper {
    @Results({
            @Result(property = "teacherIdNumber", column = "teacher_id_number"),
            @Result(property = "teacherName", column = "teacher_name")
    })
    @Select("SELECT * FROM exam_teacher")
    List<ExamTeacher> findAllTeachers();


    @Select("SELECT * FROM exam_teacher WHERE teacher_id_number = #{teacherIdNumber}")
    ExamTeacher getTeacherByIdNumber(String teacherIdNumber);

    @Insert("INSERT INTO exam_teacher (teacher_id_number, teacher_name) VALUES (#{teacherIdNumber}, #{teacherName})")
    void addTeacher(ExamTeacher teacher);

    @Update("UPDATE exam_teacher SET teacher_name = #{teacherName} WHERE teacher_id_number = #{teacherIdNumber}")
    void updateTeacher(ExamTeacher teacher);

    @Delete("DELETE FROM exam_teacher WHERE teacher_id_number = #{teacherIdNumber}")
    void deleteTeacher(String teacherIdNumber);
}

