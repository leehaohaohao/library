package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCategory {
    private Long user_category_id;
    private String user_category;

    public UserCategory(Long user_category_id, String user_category) {
        this.user_category_id = user_category_id;
        this.user_category = user_category;
    }
    public UserCategory(){}
    @Override
    public String toString() {
        return "UserCategory{" +
                "user_category_id='" + user_category_id + '\'' +
                ", user_category='" + user_category + '\'' +
                '}';
    }

    public Long getUser_category_id() {
        return user_category_id;
    }

    public void setUser_category_id(Long user_category_id) {
        this.user_category_id = user_category_id;
    }

    public String getUser_category() {
        return user_category;
    }

    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }
}
