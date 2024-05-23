package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ManagerExamCenter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerExamCenterMapper {

    @Select("SELECT ec.exam_center_name, ec.exam_center_location, r.city_name, r.districts_name, ei.exam_remain_number " +
            "FROM exam_center ec " +
            "JOIN region r ON ec.region_id = r.region_id " +
            "JOIN exam_information ei ON ec.exam_center_id = ei.exam_center_id " +
            "WHERE ec.exam_center_id = #{examCenterId}")
    @Results({
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "examCenterLocation", column = "exam_center_location"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "examRemainNumber", column = "exam_remain_number")
    })
    ManagerExamCenter manageGetExamCenterById(@Param("examCenterId") String examCenterId);

    @Insert("INSERT INTO exam_center (exam_center_id, exam_center_name, region_id, exam_center_location, exam_remain_number) " +
            "VALUES (#{examCenterId}, #{examCenterName}, #{regionId}, #{examCenterLocation}, #{examRemainNumber})")
    void manageAddExamCenter(ManagerExamCenter managerExamCenter);

    @Update("UPDATE exam_center ec " +
            "JOIN region r ON ec.region_id = r.region_id " +
            "JOIN exam_information ei ON ec.exam_center_id = ei.exam_center_id " +
            "SET ec.exam_center_name = #{examCenter.examCenterName}, " +
            "r.city_name = #{examCenter.cityName}, " +
            "ei.exam_remain_number = #{examCenter.examRemainNumber} " +
            "WHERE ec.exam_center_id = #{examCenter.examCenterId}")
    void manageUpdateExamCenter(@Param("examCenter") ManagerExamCenter examCenter);


    @Delete("DELETE FROM exam_center WHERE exam_center_id = #{examCenterId}")
    void manageDeleteExamCenter(@Param("examCenterId") String examCenterId);

    @Select("SELECT ec.exam_center_name, ec.exam_center_location, r.city_name, r.districts_name, ei.exam_remain_number " +
            "FROM exam_center ec " +
            "JOIN region r ON ec.region_id = r.region_id " +
            "JOIN exam_information ei ON ec.exam_center_id = ei.exam_center_id")
    @Results({
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "examCenterLocation", column = "exam_center_location"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "examRemainNumber", column = "exam_remain_number")
    })
    List<ManagerExamCenter> findAllExamCenters();
}
