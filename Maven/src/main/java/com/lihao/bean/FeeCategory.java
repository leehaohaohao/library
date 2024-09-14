package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeeCategory {
    private Long fee_category_id;
    private String fee_category;

    @Override
    public String toString() {
        return "FeeCategory{" +
                "fee_category_id=" + fee_category_id +
                ", fee_category='" + fee_category + '\'' +
                '}';
    }

    public Long getFee_category_id() {
        return fee_category_id;
    }

    public void setFee_category_id(Long fee_category_id) {
        this.fee_category_id = fee_category_id;
    }

    public String getFee_category() {
        return fee_category;
    }

    public void setFee_category(String fee_category) {
        this.fee_category = fee_category;
    }

    public FeeCategory(Long fee_category_id, String fee_category) {
        this.fee_category_id = fee_category_id;
        this.fee_category = fee_category;
    }
}
