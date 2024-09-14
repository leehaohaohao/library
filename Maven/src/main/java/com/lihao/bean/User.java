package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Long user_id;
    private String user_account_num;
    private String password;
    private String name;
    private String telephone_num;
    private String gender;
    private String email;
    private UserCategory userCategory;
    private BigDecimal fee_all;
    private String user_num;
    private String user_photo;
    private Boolean blacklist;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_account_num='" + user_account_num + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone_num='" + telephone_num + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", userCategory=" + userCategory +
                ", fee_all=" + fee_all +
                ", user_num='" + user_num + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", blacklist=" + blacklist +
                '}';
    }

    public Boolean getBlacklist() {
        return blacklist;
    }

    public Long getUser_id() {
        return user_id;
    }
    public Long getUser_category_id(){
        return userCategory.getUser_category_id();
    }
    public String getUser_account_num() {
        return user_account_num;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTelephone_num() {
        return telephone_num;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public UserCategory getUserCategory(){
        return userCategory;
    }

    public BigDecimal getFee_all() {
        return fee_all;
    }

    public String getUser_num() {
        return user_num;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public User(){}
    private User(Builder builder) {
        this.user_id = builder.user_id;
        this.user_account_num = builder.user_account_num;
        this.password = builder.password;
        this.name = builder.name;
        this.telephone_num = builder.telephone_num;
        this.gender = builder.gender;
        this.email = builder.email;
        this.userCategory = builder.userCategory;
        this.fee_all = builder.fee_all;
        this.user_num = builder.user_num;
        this.user_photo= builder.user_photo;
        this.blacklist=builder.blacklist;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public static class Builder {
        private Long user_id;
        private String user_account_num;
        private String password;
        private String name;
        private String telephone_num;
        private String gender;
        private String email;
        private UserCategory userCategory;
        private BigDecimal fee_all;
        private String user_num;
        private String user_photo;
        private Boolean blacklist;
        public Builder blacklist(Boolean blacklist){
            this.blacklist = blacklist;
            return this;
        }

        public Builder user_id(Long user_id){
            this.user_id=user_id;
            return this;
        }
        public Builder user_account_num(String user_account_num) {
            this.user_account_num = user_account_num;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder telephone_num(String telephone_num) {
            this.telephone_num = telephone_num;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder userCategory(UserCategory userCategory) {
            this.userCategory = userCategory;
            return this;
        }

        public Builder fee_all(BigDecimal fee_all) {
            this.fee_all = fee_all;
            return this;
        }

        public Builder user_num(String user_num) {
            this.user_num = user_num;
            return this;
        }
        public Builder user_photo(String user_photo){
            this.user_photo=user_photo;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
