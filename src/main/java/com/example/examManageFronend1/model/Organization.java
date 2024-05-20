package com.example.examManageFronend1.model;

public class Organization {
    int userId;//用户ID
    String OrganizationNumber;//机构号
    String OrganizationName;//机构名

    public void setUserId(int userId) { this.userId = userId; }
    public void setOrganizationNumber(String OrganizationNumber) { this.OrganizationNumber = OrganizationNumber; }
    public void setOrganizationName(String OrganizationName) { this.OrganizationName = OrganizationName; }
    public int getUserId() { return userId; }
    public String getOrganizationNumber() { return OrganizationNumber; }
    public String getOrganizationName() { return OrganizationName; }

    @Override
    public String toString() {
        return "Organization [userId=" + userId + ", OrganizationNumber=" + OrganizationNumber + ", OrganizationName="
                + OrganizationName + "]";
    }

}
