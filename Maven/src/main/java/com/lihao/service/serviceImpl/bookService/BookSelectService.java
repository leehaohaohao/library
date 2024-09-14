package com.lihao.service.serviceImpl.bookService;

import com.lihao.bean.Book;
import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSelectService implements BookService<Book> {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book excute(BookExcute bookExcute) throws Wrong {

        return bookDao.select_by_id(bookExcute.getBook());
    }
}
