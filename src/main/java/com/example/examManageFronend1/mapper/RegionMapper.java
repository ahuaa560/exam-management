package com.example.examManageFronend1.mapper;


import com.example.examManageFronend1.model.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("SELECT * FROM region WHERE region_id = #{regionId}")
    @Results({
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "cityName", column = "city_name")
    })
    Region selectRegionById(@Param("regionId") String regionId);

    @Select("SELECT * FROM region")
    @Results({
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "cityName", column = "city_name")
    })
    List<Region> selectAllRegions();

    @Insert("INSERT INTO region (region_id, districts_name, city_name) " +
            "VALUES (#{regionId}, #{districtsName}, #{cityName})")
    void insertRegion(Region region);

    @Update("UPDATE region SET districts_name = #{districtsName}, city_name = #{cityName} " +
            "WHERE region_id = #{regionId}")
    void updateRegion(Region region);

    @Delete("DELETE FROM region WHERE region_id = #{regionId}")
    void deleteRegion(@Param("regionId") String regionId);


    @Results({
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "cityName", column = "city_name")
    })
    @Select("SELECT * FROM region WHERE region_id = #{regionId}")
    Region getRegionById(String regionId);

    @Select("SELECT DISTINCT city_name FROM region")
    List<String> getAllCities();

    @Results({
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "cityName", column = "city_name")
    })
    @Select("SELECT * FROM region WHERE city_name = #{cityName}")
    List<Region> getRegionsByCityName(String cityName);

    @Select("SELECT DISTINCT city_name FROM region WHERE region_id IN (SELECT region_id FROM exam_center WHERE exam_center_id IN (SELECT exam_center_id FROM exam_information WHERE  exam_id= #{examId}))")
    List<String> getCityNamesByExamId(String examId);

    @Results({
            @Result(property = "regionId", column = "region_id"),
            @Result(property = "districtsName", column = "districts_name"),
            @Result(property = "cityName", column = "city_name")
    })
    @Select("SELECT * FROM region WHERE districts_name=#{districtName} ")
    Region getRegionByDistrictName( String districtName);
}

