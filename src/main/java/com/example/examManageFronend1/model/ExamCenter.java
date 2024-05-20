package com.example.examManage.model;

public class ExamCenter {
    String examCenterId;//考点号
    String examCenterName;//考点名
    String regionId;//区域号
    String examCenterLocation;//考点地址

    public String getExamCenterId() { return examCenterId; }
    public void setExamCenterId(String examCenterId) { this.examCenterId = examCenterId; }
    public String getExamCenterName() { return examCenterName; }
    public void setExamCenterName(String examCenterName) { this.examCenterName = examCenterName; }
    public String getRegionId() { return regionId; }
    public void setRegionId(String regionId) { this.regionId = regionId; }
    public String getExamCenterLocation() { return examCenterLocation; }
    public void setExamCenterLocation(String examCenterLocation) { this.examCenterLocation = examCenterLocation; }
    @Override
    public String toString() {
        return "ExamCenter [examCenterId=" + examCenterId + ", examCenterName="
                + examCenterName + ", regionId=" + regionId + ", examCenterLocation="
                + examCenterLocation + "]";
    }
}
