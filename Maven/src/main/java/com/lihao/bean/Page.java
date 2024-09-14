package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Page {
    private int page_num;
    private final int page_size = 9;

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "page_num=" + page_num +
                ", page_size=" + page_size +
                '}';
    }

    public int getPage_num() {
        return page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public int getPage_size() {
        return page_size;
    }


    public Page(int page_num) {
        this.page_num = page_num;
    }
}
