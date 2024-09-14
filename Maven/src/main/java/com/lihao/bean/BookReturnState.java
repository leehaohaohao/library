package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReturnState {
    private Long return_state_id;
    private String return_state;

    public BookReturnState(Long return_state_id, String return_state) {
        this.return_state_id = return_state_id;
        this.return_state = return_state;
    }

    @Override
    public String toString() {
        return "BookReturnState{" +
                "return_state_id=" + return_state_id +
                ", return_state='" + return_state + '\'' +
                '}';
    }

    public Long getReturn_state_id() {
        return return_state_id;
    }

    public void setReturn_state_id(Long return_state_id) {
        this.return_state_id = return_state_id;
    }

    public String getReturn_state() {
        return return_state;
    }

    public void setReturn_state(String return_state) {
        this.return_state = return_state;
    }
}
