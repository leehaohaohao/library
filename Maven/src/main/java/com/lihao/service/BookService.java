package com.lihao.service;

import com.lihao.bean.Book;
import com.lihao.bean.Page;
import com.lihao.bean.excute.BookExcute;
import com.lihao.exception.Wrong;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface BookService<T> {
    T excute(BookExcute bookExcute) throws Wrong;
}
