package com.example.examManageFronend1.mapper;


import com.example.examManageFronend1.model.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
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

}

