package com.lihao.web;

import com.lihao.bean.ResponsePack;

public class BaseServlet<T> {
    public ResponsePack<T> getSuccessResponsePack(T data){
        ResponsePack<T> responsePack = new ResponsePack<>();
        responsePack.setSuccess(true);
        responsePack.setData(data);
        return responsePack;
    }
}
