package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ExamTeacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamTeacherMapper {

    @Results({
            @Result(property = "teacherIdNumber", column = "teacher_id_number"),
            @Result(property = "teacherName", column = "teacher_name")
    })
    @Select("SELECT teacher_ID_number, teacher_name FROM exam_teacher")
    List<ExamTeacher> findAllTeachers();

    @Results({
            @Result(property = "teacherIdNumber", column = "teacher_id_number"),
            @Result(property = "teacherName", column = "teacher_name")
    })
    @Select("SELECT teacher_ID_number, teacher_name FROM exam_teacher WHERE teacher_ID_number = #{teacherIdNumber}")
    ExamTeacher findTeacherById(@Param("teacherIdNumber") String teacherIdNumber);

    @Results({
            @Result(property = "teacherIdNumber", column = "teacher_id_number"),
            @Result(property = "teacherName", column = "teacher_name")
    })
    @Update("UPDATE exam_teacher SET teacher_name = #{teacher.teacherName} WHERE teacher_ID_number = #{teacher.teacherIdNumber}")
    void updateTeacher(ExamTeacher teacher);
}

