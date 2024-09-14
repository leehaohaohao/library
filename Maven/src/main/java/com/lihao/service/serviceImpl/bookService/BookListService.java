package com.lihao.service.serviceImpl.bookService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Book;
import com.lihao.bean.Page;
import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("bookListService")
public class BookListService implements BookService<List<Book>> {
    @Autowired
    private BookDao bookDaoImpl;
    @Override
    public List<Book> excute(BookExcute bookExcute) {
        PageHelper.startPage(bookExcute.getPage().getPage_num(), bookExcute.getPage().getPage_size());
        return bookDaoImpl.select();
    }


}
