package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ExamApplyInformation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamApplyInformationMapper {
    @Results({
            @Result(property = "examId",column = "exam_id"),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "examForm",column = "exam_form"),
            @Result(property = "paymentStatu",column = "payment_status"),
            @Result(property = "examCenterId",column = "exam_center_id"),
            @Result(property = "examExamineeNumber",column = "exam_examinee_num")
    })
    @Select("SELECT * FROM exam_apply_information WHERE user_id = #{userId}")
    List<ExamApplyInformation> getExamApplyInformationByUserId(String userId);

    @Insert("insert into exam_apply_information(exam_id,user_id,exam_form,payment_status,exam_center_id,exam_examinee_number)"+
            "VALUES (#{examId},#{user_id} ,#{examForm},#{paymentStatu} ,#{examCenterId} ,#{examExamineeNumber} )")
    public void InsertExamApplyInformation(ExamApplyInformation examApplyInformation);
}

