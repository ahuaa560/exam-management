package com.example.examManageFronend1.model;


public class Examinee {
    String userId;//数据库：user_id
    boolean whiteListed;//数据库：white_listed
    String examineeName;//数据库：examinee_name
    String examineeIDNumber;//数据库：examinee_ID_number
    String examineeEmail;//数据库：examinee_email
    String examineePhone;//数据库：examinee_phone
    String organizationName;//数据库：organization_name

    @Override
    public String toString() {
        return "Examinee{" +
                "userId='" + userId + '\'' +
                ", whiteListed=" + whiteListed +
                ", examineeName='" + examineeName + '\'' +
                ", examineeIdNumber='" + examineeIDNumber + '\'' +
                ", examineeEmail='" + examineeEmail + '\'' +
                ", examineePhone='" + examineePhone + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public boolean isWhiteListed() {
        return whiteListed;
    }
    public void setWhiteListed(boolean whiteListed) {
        this.whiteListed = whiteListed;
    }
    public String getExamineeName() {
        return examineeName;
    }
    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
    }
    public String getExamineeIDNumber() {
        return examineeIDNumber;
    }
    public void setExamineeIDNumber(String examineeIDNumber) {
        this.examineeIDNumber = examineeIDNumber;
    }
    public String getExamineeEmail() {
        return examineeEmail;
    }
    public void setExamineeEmail(String examineeEmail) {
        this.examineeEmail = examineeEmail;
    }
    public String getExamineePhone() {
        return examineePhone;
    }
    public void setExamineePhone(String examineePhone) {
        this.examineePhone = examineePhone;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


}
