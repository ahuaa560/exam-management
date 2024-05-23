package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ExamInformation;
import com.example.examManageFronend1.typehandler.ExamTeacherTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ExamInformationMapper {

    @Results({
            @Result(property = "examCenterId",column = "exam_center_id"),
            @Result(property = "examId",column = "exam_id"),
            @Result(property = "startExamTime",column = "start_exam_time"),
            @Result(property = "endExamTime",column = "end_exam_time"),
            @Result(property = "examTeacher",column = "exam_teacher",typeHandler = ExamTeacherTypeHandler.class),
            @Result(property = "examRemainNumber",column = "exam_remain_number")
    })
    @Select("SELECT * FROM exam_information WHERE exam_id = #{examId}")
    List<ExamInformation> getExamInformationByExamId(String examId);


    @Results(id = "examInformationResultMap", value = {
            @Result(property = "examCenterId", column = "exam_center_id"),
            @Result(property = "examId", column = "exam_id"),
            @Result(property = "startExamTime", column = "start_exam_time"),
            @Result(property = "endExamTime", column = "end_exam_time"),
            @Result(property = "examTeacher", column = "exam_teacher", typeHandler = ExamTeacherTypeHandler.class),
            @Result(property = "examRemainNumber", column = "exam_remain_number")
    })
    @Select("SELECT ei.* " +
            "FROM exam_information ei " +
            "JOIN exam_center ec ON ei.exam_center_id = ec.exam_center_id " +
            "WHERE ei.exam_id = #{examId} AND ec.region_id = #{regionId}")
    List<ExamInformation> getExamInformationByExamIdAndRegionId( String examId, String regionId);

    @Select("SELECT exam_remain_number  FROM exam_information WHERE exam_id=#{examId} AND exam_center_id=#{centerId}")
    int getRemainNumberByExamIdAndCenterId(String examId,String centerId);

    @Update("UPDATE exam_information SET exam_remain_number=exam_remain_number+#{i} WHERE exam_id=#{examId} AND exam_center_id=#{examCenterId}")
    void updateExamemainNumber(String examId, String examCenterId, int i);
}
