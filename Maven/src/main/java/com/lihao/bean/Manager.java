package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manager {
    private Long manager_id;
    private String telephone_num;
    private String account_num;
    private String password;
    private String name;
    private String email;
    private String gender;
    private Boolean permissions;
    private Boolean isdelete;
    private String photo;
    public Manager(){}

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", telephone_num='" + telephone_num + '\'' +
                ", account_num='" + account_num + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", permissions=" + permissions +
                ", isdelete=" + isdelete +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getPhoto() {
        return photo;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public Boolean getPermissions() {
        return permissions;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public String getTelephone_num() {
        return telephone_num;
    }

    public String getAccount_num() {
        return account_num;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private Manager(Builder builder) {
        this.manager_id = builder.manager_id;
        this.telephone_num = builder.telephone_num;
        this.account_num = builder.account_num;
        this.password = builder.password;
        this.name = builder.name;
        this.email = builder.email;
        this.gender = builder.gender;
        this.permissions=builder.permissions;
        this.isdelete=builder.isdelete;
        this.photo=builder.photo;
    }

    public static class Builder {
        private Long manager_id;
        private String telephone_num;
        private String account_num;
        private String password;
        private String name;
        private String email;
        private String gender;
        private Boolean permissions;
        private Boolean isdelete;
        private String photo;
        public Builder isdelete(Boolean isdelete){
            this.isdelete=isdelete;
            return this;
        }
        public Builder permissions(Boolean permissions){
            this.permissions=permissions;
            return this;
        }
        public Builder manager_id(Long manager_id){
            this.manager_id=manager_id;
            return this;
        }

        public Builder telephone_num(String telephone_num) {
            this.telephone_num = telephone_num;
            return this;
        }

        public Builder account_num(String account_num) {
            this.account_num = account_num;
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

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder photo(String photo){
            this.photo=photo;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }
    }
}
