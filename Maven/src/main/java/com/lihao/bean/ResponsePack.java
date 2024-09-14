package com.lihao.bean;

import java.io.Serializable;

public class ResponsePack<T> implements Serializable {
    private Boolean success;
    private String message;
    private T data;

    public ResponsePack(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponsePack() {

    }

    @Override
    public String toString() {
        return "ResponsePack{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
