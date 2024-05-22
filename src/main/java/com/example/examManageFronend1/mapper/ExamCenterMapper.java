package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ExamCenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ExamCenterMapper {

    @Results({
            @Result(property = " examCenterId",column = "exam_center_id"),
            @Result(property = "regionId",column = "region_id"),
            @Result(property = "examCenterName",column = "exam_center_name"),
            @Result(property = "examCenterLocation",column = "exam_center_location")

    })
    @Select("SELECT * FROM ExamCenter WHERE regionId = #{regionId}")
    List<ExamCenter> getExamCentersByRegionId(String regionId);
}
