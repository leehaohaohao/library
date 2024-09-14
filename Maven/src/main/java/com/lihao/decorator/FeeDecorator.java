package com.lihao.decorator;

import com.lihao.bean.Fee;
import com.lihao.bean.Page;
import com.lihao.exception.Wrong;
import com.lihao.service.FeeService;

import jakarta.servlet.http.HttpServletRequest;

public class FeeDecorator<T> implements FeeService<T> {
    private FeeService<T> feeService;
    private boolean isCheck;
    public FeeDecorator(FeeService<T> feeService,boolean isCheck){
        this.feeService=feeService;
        this.isCheck=isCheck;
    }
    @Override
    public T excute(HttpServletRequest request, Page page , Fee fee) throws Wrong {
        if(isCheck){

        }
        return feeService.excute(request,page,fee);
    }
}
