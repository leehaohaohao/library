package com.lihao.bean.userDTO;

import java.io.Serializable;

public class UserBaseInfoDto implements Serializable {
    private String name;
    private String user_photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }
}
