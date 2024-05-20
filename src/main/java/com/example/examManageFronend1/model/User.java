package com.example.examManageFronend1.model;

public class User {

    String userId;
    String password;
    com.example.examManageFronend1.model.userType userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public com.example.examManageFronend1.model.userType getUserType() {
        return userType;
    }

    public void setUserType(com.example.examManageFronend1.model.userType userType) {
        this.userType = userType;
    }



    @Override
    public String toString() {
        return "Account{" +
                "id='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }




}
