package com.lihao.decorator;

import com.lihao.bean.excute.BookExcute;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;

public class BookDecorator<T> implements BookService<T> {
    private BookService<T> bookService;
    private boolean isCheck;

    public BookDecorator(BookService<T> bookService, boolean isCheck) {
        this.bookService = bookService;
        this.isCheck = isCheck;
    }

    @Override
    public T excute(BookExcute bookExcute) throws Wrong {
        if (isCheck) {

        }
        T result = bookService.excute(bookExcute);
        return result;
    }
}
