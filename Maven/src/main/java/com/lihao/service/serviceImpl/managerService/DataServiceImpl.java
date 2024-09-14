package com.lihao.service.serviceImpl.managerService;

import com.lihao.bean.Page;
import com.github.pagehelper.PageHelper;
import com.lihao.bean.User;
import com.lihao.bean.excute.BookCategoryNums;
import com.lihao.bean.excute.BorrowNumsBean;
import com.lihao.dao.BookDao;
import com.lihao.dao.BorrowDao;
import com.lihao.dao.UserDao;
import com.lihao.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public List<BorrowNumsBean> numList(Integer page_num) {
        Page page = new Page(page_num);
        PageHelper.startPage(page_num,page.getPage_size());
        return borrowDao.nums();
    }

    @Override
    public List<User> sc(Integer page_num) {
        Page page = new Page(page_num);
        PageHelper.startPage(page_num,page.getPage_size());
        return userDao.sc();
    }

    @Override
    public List<BookCategoryNums> bc() {
        return bookDao.bc();
    }
}
