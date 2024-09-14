package com.lihao.bean.userDTO;


public class UserBlacklistDto {
    private Long user_id;
    private Boolean blacklist;

    public UserBlacklistDto() {
    }

    @Override
    public String toString() {
        return "UserBlacklistDto{" +
                "user_id=" + user_id +
                ", blacklist=" + blacklist +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Boolean getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Boolean blacklist) {
        this.blacklist = blacklist;
    }
}
