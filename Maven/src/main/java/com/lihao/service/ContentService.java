package com.lihao.service;

import com.lihao.bean.Content;
import com.lihao.bean.Page;

import jakarta.servlet.http.HttpServletRequest;

public interface ContentService<T> {
    T excute(HttpServletRequest request , Page page , Content content);
}
