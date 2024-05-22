package com.example.examManageFronend1.mapper;


import com.example.examManageFronend1.model.ExamCenter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamCenterMapper {

    @Select("SELECT * FROM exam_center WHERE exam_center_id = #{examCenterId}")
    @Results({
            @Result(property = "examCenterId", column = "exam_center_id"),
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "examCenterLocation", column = "exam_center_location")
    })
    ExamCenter selectExamCenterById(@Param("examCenterId") String examCenterId);

    @Select("SELECT * FROM exam_center")
    @Results({
            @Result(property = "examCenterId", column = "exam_center_id"),
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "examCenterLocation", column = "exam_center_location")
    })
    List<ExamCenter> selectAllExamCenters();

    @Insert("INSERT INTO exam_center (exam_center_id, exam_center_name, region_id, exam_center_location) " +
            "VALUES (#{examCenterId}, #{examCenterName}, #{regionId}, #{examCenterLocation})")
    void insertExamCenter(ExamCenter examCenter);

    @Update("UPDATE exam_center SET exam_center_name = #{examCenterName}, region_id = #{regionId}, " +
            "exam_center_location = #{examCenterLocation} WHERE exam_center_id = #{examCenterId}")
    void updateExamCenter(ExamCenter examCenter);

    @Delete("DELETE FROM exam_center WHERE exam_center_id = #{examCenterId}")
    void deleteExamCenter(@Param("examCenterId") String examCenterId);



    @Results({
            @Result(property = "examCenterId", column = "exam_center_id"),
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "examCenterLocation", column = "exam_center_location")
    })
    @Select("SELECT * FROM exam_center WHERE region_id = #{regionId}")
    List<ExamCenter> getExamCentersByRegionId(String regionId);

}
