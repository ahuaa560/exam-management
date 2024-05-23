package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.Exam;
import com.example.examManageFronend1.model.ExamForm;
import com.example.examManageFronend1.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamMapper {

    @Results({
            @Result(property ="examId",column = "exam_id"),
            @Result(property ="examForm",column = "exam_form"),
            @Result(property ="startApplyTime",column = "start_apply_time"),
            @Result(property ="startExamTime",column = "start_exam_time"),
            @Result(property ="endExamTime",column = "end_exam_time"),
            @Result(property ="endApplyTime",column = "end_apply_time"),
            @Result(property ="examPayment",column = "exam_payment"),
            @Result(property ="examName",column = "exam_name")
    })
    @Select("SELECT * FROM exam")
    List<Exam> findAll();

    @Select("SELECT * FROM exam WHERE exam_id = #{examId}")
    Exam findById(String examId);

    @Insert("INSERT INTO exam (exam_id, exam_form, start_apply_time, end_apply_time, start_exam_time, end_exam_time, exam_payment, exam_name) VALUES ( #{examId}, #{examForm}, #{startApplyTime}, #{endApplyTime}, #{startExamTime}, #{endExamTime}, #{examPayment}, #{examName})")
    int insert(Exam exam);


    @Results({
            @Result(property ="examId",column = "exam_id"),
            @Result(property ="examForm",column = "exam_form"),
            @Result(property ="startApplyTime",column = "start_apply_time"),
            @Result(property ="startExamTime",column = "start_exam_time"),
            @Result(property ="endExamTime",column = "end_exam_time"),
            @Result(property ="endApplyTime",column = "end_apply_time"),
            @Result(property ="examPayment",column = "exam_payment"),
            @Result(property ="examName",column = "exam_name")
    })
    @Delete("DELETE FROM exam WHERE exam_id = #{examId}")
    void deleteById(String examId);

    @Results({
            @Result(property ="examId",column = "exam_id"),
            @Result(property ="examForm",column = "exam_form"),
            @Result(property ="startApplyTime",column = "start_apply_time"),
            @Result(property ="startExamTime",column = "start_exam_time"),
            @Result(property ="endExamTime",column = "end_exam_time"),
            @Result(property ="endApplyTime",column = "end_apply_time"),
            @Result(property ="examPayment",column = "exam_payment"),
            @Result(property ="examName",column = "exam_name")
    })
    @Select("SELECT * FROM exam WHERE start_apply_time <= NOW() AND end_apply_time >= NOW()")
    List<Exam> getActiveExams();

    @Results({
            @Result(property ="examId",column = "exam_id"),
            @Result(property ="examForm",column = "exam_form"),
            @Result(property ="startApplyTime",column = "start_apply_time"),
            @Result(property ="startExamTime",column = "start_exam_time"),
            @Result(property ="endExamTime",column = "end_exam_time"),
            @Result(property ="endApplyTime",column = "end_apply_time"),
            @Result(property ="examPayment",column = "exam_payment"),
            @Result(property ="examName",column = "exam_name")
    })
    @Select("SELECT * FROM exam WHERE exam_id = #{examId}")
    Exam getExamByExamId(String examId);

    @Select("SELECT exam_form FROM exam_apply_information WHERE exam_id =#{examId} ")
    ExamForm getExamFormByExamId(String examId);
}
