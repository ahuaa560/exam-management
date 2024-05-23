package com.example.examManageFronend1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamineeNecessaryMapper {


    @Insert("INSERT INTO examinee_necessary(exam_examinee_number,examinee_demand,solve_status) "+
    "VALUES (#{examExamineeNum},#{examineeDemand},#{solveStatus})")
     void addNecessary(String examExamineeNum, String examineeDemand,boolean solveStatus) ;
}
