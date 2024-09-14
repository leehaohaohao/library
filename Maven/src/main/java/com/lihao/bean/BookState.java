package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookState {
    private Long book_state_id;
    private String book_state;

    public BookState(Long book_state_id, String book_state) {
        this.book_state_id = book_state_id;
        this.book_state = book_state;
    }
    public BookState(){}

    @Override
    public String toString() {
        return "BookState{" +
                "book_state_id=" + book_state_id +
                ", book_state='" + book_state + '\'' +
                '}';
    }

    public Long getBook_state_id() {
        return book_state_id;
    }

    public void setBook_state_id(Long book_state_id) {
        this.book_state_id = book_state_id;
    }

    public String getBook_state() {
        return book_state;
    }

    public void setBook_state(String book_state) {
        this.book_state = book_state;
    }
}
