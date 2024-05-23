package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.ExamineeNecessary;
import com.example.examManageFronend1.typehandler.ExamTeacherTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamineeNecessaryMapper {


    @Results({
            @Result(property = "examExamineeNumber",column = "exam_examinee_number"),
            @Result(property = "examineeDemand",column = "examinee_demand"),
            @Result(property = "solveStatus",column = "solve_status")
    })
    @Insert("INSERT INTO examinee_necessary(exam_examinee_number,examinee_demand,solve_status) "+
    "VALUES (#{examExamineeNum},#{examineeDemand},#{solveStatus})")
     void addNecessary(String examExamineeNum, String examineeDemand,boolean solveStatus) ;


    @Results({
            @Result(property = "examExamineeNumber",column = "exam_examinee_number"),
            @Result(property = "examineeDemand",column = "examinee_demand"),
            @Result(property = "solveStatus",column = "solve_status")
    })
    @Select("SELECT exam_examinee_number, examinee_demand, solve_status FROM examinee_necessary")
    List<ExamineeNecessary> findAllExamineeNecessary();

    @Results({
            @Result(property = "examExamineeNumber",column = "exam_examinee_number"),
            @Result(property = "examineeDemand",column = "examinee_demand"),
            @Result(property = "solveStatus",column = "solve_status")
    })
    @Update("UPDATE examinee_necessary SET solve_status = #{solveStatus} WHERE exam_examinee_number = #{examExamineeNumber}")
    void updateSolveStatus(ExamineeNecessary examineeNecessary);
}
