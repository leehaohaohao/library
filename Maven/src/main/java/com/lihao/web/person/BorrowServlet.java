package com.lihao.web.person;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Book;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.exception.Wrong;
import com.lihao.service.BorrowService;
import com.lihao.decorator.BorrowTimeOutDecorator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping({"/filter1/person/book"})
public class BorrowServlet {
    @Autowired
    @Qualifier("borrowBookListService")
    private BorrowService<List<BookBorrow>> borrowList;

    @Autowired
    @Qualifier("borrowBookReturnService")
    private BorrowService<String> borrowBookReturn;

    @Autowired
    @Qualifier("borrowBookRenewService")
    private BorrowService<String> borrowBookRenew;

    @Autowired
    @Qualifier("borrowBookLostService")
    private BorrowService<String> borrowBookLost;

    @Autowired
    @Qualifier("borrowBookHistoryService")
    private BorrowService<List<BookBorrow>> borrowBookHistory;

    @RequestMapping("/borrowed")
    public ResponsePack<List<BookBorrow>> doPerson_book_borrowed(HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<List<BookBorrow>> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowList,false);
        BookBorrow bookBorrow = new BookBorrow();
        ResponsePack<List<BookBorrow>> responsePack = new ResponsePack<>();
        responsePack.setData(borrowTimeOutDecorator.excute(request,bookBorrow,null,new Page(0),null));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/borrowed/return")
    public ResponsePack<String> doPerson_book_borrowed_return(Long borrow_id, HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<String> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowBookReturn,true);
        BookBorrow bookBorrow = new BookBorrow.Builder()
                .borrow_id(borrow_id)
                .build();
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(borrowTimeOutDecorator.excute(request,bookBorrow,null,new Page(0),null));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/borrowed/renew")
    public ResponsePack<String> doPerson_book_borrowed_renew(@RequestParam("borrow_id") Long borrowId,HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<String> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowBookRenew,true);
        BookBorrow bookBorrow = new BookBorrow.Builder()
                .borrow_id(borrowId)
                .build();
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(borrowTimeOutDecorator.excute(request,bookBorrow,null,new Page(0), null));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/borrowed/lost")
    public ResponsePack<String> doPerson_book_borrowed_lost(@RequestParam("borrow_id") Long borrowId,HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<String> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowBookLost,true);
        BookBorrow bookBorrow = new BookBorrow.Builder()
                .borrow_id(borrowId)
                .build();
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(borrowTimeOutDecorator.excute(request,bookBorrow,null,new Page(0),null));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/borrowed/history/select")
    public ResponsePack<PageInfo<BookBorrow>> doPerson_book_borrowed_history_select(@RequestParam("page_num") int pageNum, HttpServletRequest request) throws Wrong {
        BorrowTimeOutDecorator<List<BookBorrow>> borrowTimeOutDecorator = new BorrowTimeOutDecorator<>(borrowBookHistory,false);
        ResponsePack<PageInfo<BookBorrow>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(borrowTimeOutDecorator.excute(request,null,null,new Page(pageNum),null)));
        responsePack.setSuccess(true);
        return responsePack;
    }
}
