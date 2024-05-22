package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.Organization;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrganizationMapper {

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "OrganizationNumber",column = "organization_number"),
            @Result(property = "OrganizationName",column = "organization_name")
    })
    @Select("SELECT * FROM organization WHERE user_id=#{userId} ")
    Organization findByUserId(String userId);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "OrganizationNumber",column = "organization_number"),
            @Result(property = "OrganizationName",column = "organization_name")
    })
    @Select("SELECT * FROM organization  ")
    Organization findAll();

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "OrganizationNumber",column = "organization_number"),
            @Result(property = "OrganizationName",column = "organization_name")
    })
    @Insert("INSERT INTO organization (user_id, organization_number, organization_name ) VALUES ( #{user_id}, #{organization_number}, #{organization_name}) ")
    int insert(Organization organization);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "OrganizationNumber",column = "organization_number"),
            @Result(property = "OrganizationName",column = "organization_name")
    })
    @Delete("DELETE FROM organization WHERE user_id = #{user_id} OR organization_number = #{organization_number} OR organization_name = #{organization_name} ")
    int delete(Organization organization);
}
