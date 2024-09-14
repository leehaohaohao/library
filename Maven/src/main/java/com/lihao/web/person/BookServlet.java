package com.lihao.web.person;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Book;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.bean.excute.BookExcute;
import com.lihao.decorator.BookDecorator;
import com.lihao.decorator.BorrowTimeOutDecorator;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import com.lihao.service.BorrowService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping({"/filter1/book"})
public class BookServlet {
    @Autowired
    @Qualifier("borrowBookService")
    private BorrowService<String> borrowBookService;

    @Autowired
    @Qualifier("bookListService")
    private BookService<List<Book>> bookListService;

    @Autowired
    @Qualifier("bookRankService")
    private BookService<List<Book>> bookRankService;

    @Autowired
    @Qualifier("bookListSearchService")
    private BookService<List<Book>> bookListSearchService;

    @RequestMapping ("/list/select")
    public ResponsePack<PageInfo<Book>> doBook_select(@RequestParam("page_num") Page page) throws Wrong {
        BookDecorator<List<Book>> bookDecorator = new BookDecorator<>(bookListService,false);
        BookExcute bookExcute = new BookExcute.Builder()
                .page(page)
                .build();
        ResponsePack<PageInfo<Book>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(bookDecorator.excute(bookExcute)));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/list/borrow")
    public ResponsePack<String> doBook_borrow(@RequestParam("book_id") Long book_id ,HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<String> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowBookService,false);
        Book book = new Book.Builder()
                .book_id(book_id)
                .build();
        BookBorrow bookBorrow = new BookBorrow();
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(borrowTimeOutDecorator.excute(request,bookBorrow,book,new Page(0),null));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/rank/select")
    public ResponsePack<PageInfo<Book>> doBook_select_rank(@ModelAttribute("page_num") Page page) throws Wrong {
        BookDecorator<List<Book>> bookDecorator = new BookDecorator<>(bookRankService,false);
        BookExcute bookExcute = new BookExcute.Builder()
                .page(page)
                .build();
        ResponsePack<PageInfo<Book>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(bookDecorator.excute(bookExcute)));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/list/search")
    public ResponsePack<PageInfo<Book>> doBookSearch(@RequestParam("query") String query, @ModelAttribute("page_num") Page page) throws Wrong {
        BookDecorator<List<Book>> bookDecorator = new BookDecorator<>(bookListSearchService,false);
        BookExcute bookExcute = new BookExcute.Builder()
                .query(query)
                .page(page)
                .build();
        ResponsePack<PageInfo<Book>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(bookDecorator.excute(bookExcute)));
        responsePack.setSuccess(true);
        return responsePack;
    }
}
