package com.lihao.bean.userDTO;

import java.util.Arrays;

public class UserIdDto {
    private Long[] user_ids;

    public UserIdDto() {
    }

    @Override
    public String toString() {
        return "UserIdDto{" +
                "user_ids=" + Arrays.toString(user_ids) +
                '}';
    }

    public Long[] getUser_ids() {
        return user_ids;
    }

    public void setUser_ids(Long[] user_ids) {
        this.user_ids = user_ids;
    }
}
