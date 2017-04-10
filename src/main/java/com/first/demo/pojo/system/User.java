package com.first.demo.pojo.system;

public class User {

    private Integer user_id;

    private String username;

    private String password;


    public Integer getUserid() {
        return user_id;
    }

    public void setUserid(Integer userid) {
        this.user_id = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}