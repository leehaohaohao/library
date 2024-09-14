package com.lihao.web.manager;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.ResponsePack;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerBorrowService;
import com.lihao.web.BaseServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/borrowed")
public class ManagerBorrowedServlet extends BaseServlet {
    @Autowired
    private ManagerBorrowService borrowServiceImpl;
    @RequestMapping("/return")
    public ResponsePack<PageInfo<List<BookBorrow>>> bookReturn(Integer page_num){
        return getSuccessResponsePack(borrowServiceImpl.bookReturn(page_num));
    }
    @RequestMapping("/return/agree")
    public ResponsePack<String> returnAgree(Long borrow_id) throws Wrong {
        return getSuccessResponsePack(borrowServiceImpl.returnAgree(borrow_id));
    }
    @RequestMapping("/return/lost")
    public ResponsePack returnLost(Long borrow_id) throws Wrong {
        return getSuccessResponsePack(borrowServiceImpl.returnLost(borrow_id));
    }
}
