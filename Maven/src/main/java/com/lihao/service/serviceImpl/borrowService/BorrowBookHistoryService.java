package com.lihao.service.serviceImpl.borrowService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Book;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.Page;
import com.lihao.dao.BorrowDao;
import com.lihao.exception.Wrong;
import com.lihao.service.BorrowService;
import com.lihao.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class BorrowBookHistoryService implements BorrowService<List<BookBorrow>> {
    @Autowired
    private BorrowDao borrowDao;
    @Override
    public List<BookBorrow> excute(HttpServletRequest request, BookBorrow bookBorrow, Book book, Page page, MultipartFile file) throws Wrong {
        PageHelper.startPage(page.getPage_num(), page.getPage_size());
        Long user_id = SessionUtil.getUserId(request);
        return borrowDao.select_book_borrowed_history(user_id);
    }
}
