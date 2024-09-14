package com.lihao.service;

import com.lihao.bean.BookBorrow;
import com.lihao.exception.Wrong;

import java.util.List;

public interface ManagerBorrowService {
    List<BookBorrow> bookReturn(Integer page_num);
    String returnAgree(Long borrow_id) throws Wrong;
    String returnLost(Long borrow_id) throws Wrong;
}
