package com.lihao.handler;

import com.lihao.bean.ResponsePack;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponsePack exception(Exception e){
        e.printStackTrace();
        return new ResponsePack(false,e.getMessage(),null);
    }
}
