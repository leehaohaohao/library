package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fee {
    private Long fee_id;
    private FeeCategory feeCategory;
    private FeeState feeState;
    private User user;
    private BigDecimal fee_num;
    private String book;

    @Override
    public String toString() {
        return "Fee{" +
                "fee_id=" + fee_id +
                ", feeCategory=" + feeCategory +
                ", feeState=" + feeState +
                ", user=" + user +
                ", fee_num=" + fee_num +
                ", book='" + book + '\'' +
                '}';
    }

    public Fee() {
    }
    private Fee(Builder builder){
        this.fee_id = builder.fee_id;
        this.feeCategory = builder.feeCategory;
        this.feeState = builder.feeState;
        this.user=builder.user;
        this.fee_num=builder.fee_num;
        this.book = builder.book;
    }
    public String getBook() {
        return book;
    }
    public Long getFee_id() {
        return fee_id;
    }

    public FeeCategory getFeeCategory() {
        return feeCategory;
    }
    public Long getFee_category_id(){
        return  feeCategory.getFee_category_id();
    }
    public FeeState getFeeState() {
        return feeState;
    }
    public Long getFee_state_id(){
        return feeState.getFee_state_id();
    }
    public BigDecimal getFee_num(){
        return fee_num;
    }

    public User getUser() {
        return user;
    }
    public Long getUser_id(){
        return user.getUser_id();
    }
    public static class Builder{
        private Long fee_id;
        private FeeCategory feeCategory;
        private FeeState feeState;
        private User user;
        private BigDecimal fee_num;
        private String book;
        public Builder fee_id(Long fee_id){
            this.fee_id=fee_id;
            return this;
        }
        public Builder feeCategory(FeeCategory feeCategory){
            this.feeCategory=feeCategory;
            return this;
        }
        public Builder feeState(FeeState feeState){
            this.feeState=feeState;
            return this;
        }
        public Builder user(User user){
            this.user = user;
            return this;
        }
        public Builder fee_num(BigDecimal fee_num){
            this.fee_num=fee_num;
            return this;
        }
        public Builder book(String book){
            this.book=book;
            return this;
        }
        public Fee builder(){
            return new Fee(this);
        }
    }
}
