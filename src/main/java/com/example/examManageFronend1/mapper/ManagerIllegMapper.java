package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ManagerIlleg;
import com.example.examManageFronend1.service.ManagerIllegService;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerIllegMapper {

    @Select("SELECT e.exam_name, ec.exam_center_name, i.illegal_time, i.illegal_information " +
            "FROM illeg i " +
            "JOIN exam e ON i.exam_id = e.exam_id " +
            "JOIN exam_center ec ON i.exam_center_id = ec.exam_center_id")
    @Results({
            @Result(property = "examName", column = "exam_name"),
            @Result(property = "examCenterName", column = "exam_center_name"),
            @Result(property = "illegalTime", column = "illegal_time"),
            @Result(property = "illegalInformation", column = "illegal_information")
    })
    List<ManagerIlleg> findAllManagerIlleg();

    @Insert("INSERT INTO illeg (exam_id, exam_center_id, illegal_time, illegal_information) " +
            "VALUES (#{examId}, #{examCenterId}, #{illegalTime}, #{illegalInformation})")
    void addManagerIlleg(ManagerIlleg managerIlleg);
}
