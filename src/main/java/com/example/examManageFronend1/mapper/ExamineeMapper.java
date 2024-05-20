package com.example.examManage.mapper;

import com.example.examManage.model.Examinee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface ExamineeMapper {

    @Select("SELECT * from examinee")
    List<Examinee> findAll();

    @Insert("insert into examinee values (#{whiteListed} ,#{userId} #{examineeName} ,#{examineeIDNumber}, #{examineePhone} ,#{examineeEmail} ,#{organizationName} ")
    void insertExaminee(Examinee examinee);

    @Select("SELECT * FROM examinee WHERE user_id = #{userId}")
    Examinee getExamineeById(String userId);


    @Update("UPDATE examinee SET white_listed = #{whiteListed}, examinee_name = #{examineeName}, examinee_ID_number = #{examineeIDNumber}, " +
            "examinee_email = #{examineeEmail}, examinee_phone = #{examineePhone}, organization_name = #{organizationName} WHERE user_id = #{userId}")
    void updateExaminee(Examinee examinee);

    @Delete("DELETE FROM examinee WHERE user_id = #{userId}")
    void deleteExaminee(String userId);

}
