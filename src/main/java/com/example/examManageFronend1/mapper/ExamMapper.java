package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.User;
import org.apache.ibatis.annotations.*;
import com.example.examManageFronend1.model.Exam;

import java.util.List;

@Mapper
public interface ExamMapper {

    @Select("SELECT * FROM exam")
    List<Exam> findAll();

    @Select("SELECT * FROM user WHERE exam_id = #{examId}")
    User findById(String userId);

    @Insert("INSERT INTO exam (exam_id, exam_form, start_apply_time, end_apply_time, start_exam_time, end_exam_time, exam_payment, exam_name) VALUES (#value  {examId}, #{examForm}, #{startApplyTime}, #{endApplyTime}, #{startExamTime}, #{endExamTime}, #{examPayment}, #{examName})")
    int insert(Exam exam);

    @Delete("DELETE FROM exam WHERE id = #{examId}")
    void deleteById(String examId);
}
