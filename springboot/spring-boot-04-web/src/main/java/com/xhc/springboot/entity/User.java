package com.xhc.springboot.entity;

/**
 * @Title: User
 * @Description: com.xhc.springboot.entity
 * @Auther: www.xhc.com
 * @Version: 1.0
 */
public class User {
    private String username;
    // 1 女生 ， 2 男生
    private Integer gender;

    public User() {
    }

    public User(String username, Integer gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
