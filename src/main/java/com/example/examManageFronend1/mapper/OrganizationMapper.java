package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrganizationMapper {

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "OrganizationNumber",column = "organization_number"),
            @Result(property = "OrganizationName",column = "organization_name")
    })
    @Select("SELECT * FROM organization WHERE user_id=#{userId} ")
    Organization findByUserId(String userId);
}
