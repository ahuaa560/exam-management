package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrganizationMapper {

    @Select("SELECT * FROM organization WHERE user_id=#{userId} ")
    Organization findByUserId(String userId);
}
