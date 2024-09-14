package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeeState {
    private Long fee_state_id;
    private String fee_state;

    public FeeState(Long fee_state_id, String fee_state) {
        this.fee_state_id = fee_state_id;
        this.fee_state = fee_state;
    }

    @Override
    public String toString() {
        return "FeeState{" +
                "fee_state_id=" + fee_state_id +
                ", fee_state='" + fee_state + '\'' +
                '}';
    }

    public Long getFee_state_id() {
        return fee_state_id;
    }

    public void setFee_state_id(Long fee_state_id) {
        this.fee_state_id = fee_state_id;
    }

    public String getFee_state() {
        return fee_state;
    }

    public void setFee_state(String fee_state) {
        this.fee_state = fee_state;
    }
}
