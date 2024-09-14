package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content {
    private Long content_id;
    private String content;
    private Date publish_date;
    private Long like_num;
    private User user;
    private UserCategory userCategory;
    public Content(){}

    public Content(Long content_id, String content, Date publish_date, Long like_num, User user, UserCategory userCategory) {
        this.content_id = content_id;
        this.content = content;
        this.publish_date = publish_date;
        this.like_num = like_num;
        this.user = user;
        this.userCategory = userCategory;
    }

    @Override
    public String toString() {
        return "Content{" +
                "content_id=" + content_id +
                ", content='" + content + '\'' +
                ", publish_date=" + publish_date +
                ", like_num=" + like_num +
                ", user=" + user +
                ", user_category=" + userCategory +
                '}';
    }

    public Long getContent_id() {
        return content_id;
    }

    public String getContent() {
        return content;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public Long getLike_num() {
        return like_num;
    }

    public User getUser() {
        return user;
    }
    public String getName(){
        if(user!=null){
            return user.getName();
        }
        return null;
    }
    public Long getUser_id(){
        if(user!=null){
            return user.getUser_id();
        }
        return null;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public void setLike_num(Long like_num) {
        this.like_num = like_num;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public UserCategory getUserCategory() {
        if(userCategory!=null){
            return userCategory;
        }
        return null;
    }
    public Long getUser_category_id(){
        if(userCategory!=null){
            return userCategory.getUser_category_id();
        }
        return null;
    }
    private Content(Builder builder){
        this.content= builder.content;
        this.user=builder.user;
        this.content_id= builder.content_id;
        this.userCategory=builder.userCategory;
        this.like_num= builder.like_num;
        this.publish_date=builder.publish_date;
    }
    public static class Builder{
        private Long content_id;
        private String content;
        private Date publish_date;
        private Long like_num;
        private User user;
        private UserCategory userCategory;
        public Builder content_id(Long content_id){
            this.content_id=content_id;
            return this;
        }
        public Builder content(String content){
            this.content=content;
            return this;
        }
        public Builder publish_date(Date publish_date){
            this.publish_date=publish_date;
            return this;
        }
        public Builder like_num(Long like_num){
            this.like_num=like_num;
            return this;
        }
        public Builder user(User user){
            this.user=user;
            return this;
        }
        public Builder userCategory(UserCategory userCategory){
            this.userCategory=userCategory;
            return this;
        }
        public Content build(){
            return new Content(this);
        }
    }

}
