package com.lihao.service;

import com.lihao.bean.Book;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.Page;
import com.lihao.exception.Wrong;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface BorrowService<T> {
    T excute(HttpServletRequest request, BookBorrow bookBorrow, Book book, Page page, MultipartFile file) throws Wrong;
}
