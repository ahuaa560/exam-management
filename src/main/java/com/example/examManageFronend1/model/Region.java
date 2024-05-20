package com.example.examManageFronend1.model;

public class Region {
    String regionId;//区域号
    String districtsName;//县级名
    String cityName;//市级名
    public void setRegionId(String regionId) { this.regionId = regionId; }
    public String getRegionId() { return regionId; }
    public void setDistrictsName(String districtsName) { this.districtsName = districtsName; }
    public String getDistrictsName() { return districtsName; }
    public void setCityName(String cityName) { this.cityName = cityName; }
    public String getCityName() { return cityName; }

    @Override
    public String toString() {
        return "Region [regionId=" + regionId + ", districtsName=" + districtsName
                + ", cityName=" + cityName + "]";
    }
}
