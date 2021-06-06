package com.example.lkhayal_admin;

public class user {


    private String userID, userEmail, userPasswd, userFName, userLName, description, userType, userPhone;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public user() {
    }

    public user(String userID, String userFName) {
        this.userID = userID;
        this.userFName = userFName;
    }

    public user(String userEmail, String userPasswd, String userFName, String userLName, String description, String userType, String userPhone) {
        this.userEmail = userEmail;
        this.userPasswd = userPasswd;
        this.userFName = userFName;
        this.userLName = userLName;
        this.description = description;
        this.userType = userType;
        this.userPhone = userPhone;
    }

    public user(String userID, String userEmail, String userPasswd, String userFName, String userLName, String description, String userType, String userPhone) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPasswd = userPasswd;
        this.userFName = userFName;
        this.userLName = userLName;
        this.description = description;
        this.userType = userType;
        this.userPhone = userPhone;
    }

    public user(String userID, String userEmail, String userPasswd, String userFName, String userLName, String userPhone) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userPasswd = userPasswd;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPhone = userPhone;
    }

    public user(String userEmail, String userPasswd, String userFName, String userLName, String userPhone) {
        this.userEmail = userEmail;
        this.userPasswd = userPasswd;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPhone = userPhone;
    }
}
