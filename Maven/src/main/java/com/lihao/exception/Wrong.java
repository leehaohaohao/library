package com.lihao.exception;

/**
 * 错误类型“查无此人”
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class Wrong extends Exception{
    public Wrong(){

    }
    public Wrong(String msg){
        super(msg);
    }

}
