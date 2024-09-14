package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Press {
    private Long press_id;
    private String press;

    public Press(Long press_id, String press) {
        this.press_id = press_id;
        this.press = press;
    }
    public Press(){}
    @Override
    public String toString() {
        return press;
    }

    public Long getPress_id() {
        return press_id;
    }

    public void setPress_id(Long press_id) {
        this.press_id = press_id;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
