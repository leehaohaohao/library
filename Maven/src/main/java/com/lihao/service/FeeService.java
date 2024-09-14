package com.lihao.service;

import com.lihao.bean.Fee;
import com.lihao.bean.Page;
import com.lihao.exception.Wrong;

import jakarta.servlet.http.HttpServletRequest;

public interface FeeService<T> {
    T excute(HttpServletRequest request, Page page, Fee fee) throws Wrong;
}
