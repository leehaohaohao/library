package com.lihao.service;

import com.lihao.bean.User;
import com.lihao.bean.excute.BookCategoryNums;
import com.lihao.bean.excute.BorrowNumsBean;

import java.util.List;

public interface DataService {
    List<BorrowNumsBean> numList(Integer page_num);
    List<User> sc(Integer page_num);
    List<BookCategoryNums> bc();
}
