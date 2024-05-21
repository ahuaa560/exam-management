package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "password",column = "password"),
            @Result(property = "userType",column = "user_type")
    })
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User findById(String userId);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "password",column = "password"),
            @Result(property = "userType",column = "user_type")
    })
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user( password, user_type) VALUES( #{password}, #{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    void insert(User user);

    @Update("UPDATE user SET password = #{password}, user_type = #{userType} WHERE user_id = #{userId}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{usrId}")
    void delete(String userId);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "password",column = "password"),
            @Result(property = "userType",column = "user_type")
    })
    @Select("SELECT * FROM user WHERE user_id=#{userId} ")
    User findByUserId(String userId);
}

