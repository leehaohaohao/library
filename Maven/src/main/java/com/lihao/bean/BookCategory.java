package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookCategory {
    private Long category_id;
    private String category;

    @Override
    public String toString() {
        return category;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookCategory(Long category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }
    public BookCategory(){}
}
