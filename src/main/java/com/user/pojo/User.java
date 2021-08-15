package com.user.pojo;

public class User {

    private String userID;
    private String userName;
    private String userPwd;
    private String userRoot;

    public User() {
    }

    public User(String userID, String userName, String userPwd, String userRoot, String userBooks) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRoot = userRoot;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRoot() {
        return userRoot;
    }

    public void setUserRoot(String userRoot) {
        this.userRoot = userRoot;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRoot='" + userRoot + '\'' +
                '}';
    }
}
