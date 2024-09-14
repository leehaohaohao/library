package com.lihao.service.serviceImpl.borrowService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.*;
import com.lihao.dao.BorrowDao;
import com.lihao.dao.FeeDao;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerBorrowService;
import com.lihao.utils.LongUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ManagerBorrowServiceImpl implements ManagerBorrowService {
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private FeeDao feeDao;
    @Override
    public List<BookBorrow> bookReturn(Integer page_num) {
        return borrowDao.bookReturn();
    }

    @Override
    public String returnAgree(Long borrow_id) throws Wrong {
        if(borrow_id==null){
            throw new Wrong("请求错误！");
        }
        BookBorrow bookBorrow = new BookBorrow.Builder().borrow_id(borrow_id).build();
        bookBorrow =  borrowDao.select_book_borrowed(bookBorrow);
        if(bookBorrow.getBookState().getBook_state_id()!=5L){
            throw new Wrong("请求错误！");
        }
        if(borrowDao.update_book_return(borrow_id,1L,new Date(),null,4L)==1){
            return "已批准！";
        }
        throw new Wrong("批准失败！");
    }

    @Override
    public String returnLost(Long borrow_id) throws Wrong {
        if(borrow_id==null){
            throw new Wrong("请求错误！");
        }
        BookBorrow bookBorrow = new BookBorrow.Builder().borrow_id(borrow_id).build();
        bookBorrow =  borrowDao.select_book_borrowed(bookBorrow);
        if(bookBorrow.getBookState().getBook_state_id()!=5L){
            throw new Wrong("请求错误！");
        }
        FeeCategory feeCategory = new FeeCategory(LongUtil.getFee_incomplete(), null);
        FeeState feeState = new FeeState(LongUtil.getFee_unpaid(),null);
        Fee fee = new Fee.Builder()
                .fee_num(bookBorrow.getBook().getBook_money())
                .feeCategory(feeCategory)
                .feeState(feeState)
                .user(bookBorrow.getUser())
                .book(bookBorrow.getBook().getBook())
                .builder();
        if(feeDao.insert(fee)!=1){
            throw new Wrong("系统出现异常！");
        }
        if(borrowDao.update_book_return(borrow_id,1L,new Date(),null,3L)==1){
            return "已定损批准！";
        }
        throw new Wrong("定损批准失败！");
    }
}
