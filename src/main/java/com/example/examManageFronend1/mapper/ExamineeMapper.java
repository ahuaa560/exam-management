package com.example.examManageFronend1.mapper;

import com.example.examManageFronend1.model.Examinee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamineeMapper {

    @Select("SELECT * from examinee")
    List<Examinee> findAll();

    @Insert("insert into examinee(white_listed,user_id,examinee_name,examinee_ID_number,examinee_phone,examinee_email,organization_name) values (#{whiteListed} ,#{userId} ,#{examineeName} ,#{examineeIDNumber}, #{examineePhone} ,#{examineeEmail} ,#{organizationName} )")
    void insertExaminee(Examinee examinee);

    @Select("SELECT COUNT(*) FROM examinee WHERE examinee_ID_number = #{examineeIDNumber}")
    int countByIdCard(String examineeIDNumber);

    @Select("SELECT COUNT(*) FROM examinee WHERE examinee_phone = #{examineePhone}")
    int countByPhoneNumber(String examineePhone);

    @Select("SELECT COUNT(*) FROM examinee WHERE examinee_email = #{examineeEmail}")
    int countByEmail(String examineeEmail);


    @Select("SELECT * FROM examinee WHERE user_id = #{userId}")
    Examinee getExamineeById(String userId);


    @Update("UPDATE examinee SET white_listed = #{whiteListed}, examinee_name = #{examineeName}, examinee_ID_number = #{examineeIDNumber}, " +
            "examinee_email = #{examineeEmail}, examinee_phone = #{examineePhone}, organization_name = #{organizationName} WHERE user_id = #{userId}")
    void updateExaminee(Examinee examinee);

    @Delete("DELETE FROM examinee WHERE user_id = #{userId}")
    void deleteExaminee(String userId);

    @Select("SELECT * FROM examinee WHERE examinee_ID_number = #{idNumber} OR examinee_email = #{email} OR examinee_phone = #{phone}")
    Examinee findByIdNumberOrEmailOrPhone(String idNumber, String email, String phone);
}
