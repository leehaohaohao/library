package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notice {
    private Long notice_id;
    private String notice_content;
    private Date notice_date;
    private Manager manager;
    private Boolean effective;

    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice_content='" + notice_content + '\'' +
                ", notice_date=" + notice_date +
                ", manager=" + manager +
                ", effective=" + effective +
                '}';
    }

    public Long getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Long notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public Date getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(Date notice_date) {
        this.notice_date = notice_date;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }
    private Notice (Builder builder){
        this.effective=builder.effective;
        this.notice_content= builder.notice_content;
        this.notice_date=builder.notice_date;
        this.notice_id= builder.notice_id;
        this.manager=builder.manager;
    }
    public static class Builder{
        private Long notice_id;
        private String notice_content;
        private Date notice_date;
        private Manager manager;
        private Boolean effective;
        public Builder notice_id(Long notice_id){
            this.notice_id=notice_id;
            return this;
        }
        public Builder notice_content(String notice_content){
            this.notice_content=notice_content;
            return this;
        }
        public Builder notice_date(Date notice_date){
            this.notice_date=notice_date;
            return this;
        }
        public Builder manager(Manager manager){
            this.manager=manager;
            return this;
        }
        public Builder effective(Boolean effective){
            this.effective=effective;
            return this;
        }
        public Notice builder(){
            return new Notice(this);
        }
    }
}
