package com.lihao.service.serviceImpl.borrowService;

import com.lihao.bean.*;
import com.lihao.dao.*;
import com.lihao.exception.Wrong;
import com.lihao.service.BorrowService;
import com.lihao.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Transactional
@Service("borrowBookService")
public class BorrowBookService implements BorrowService<String> {
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserCategoryDao userCategoryDao;
    @Autowired
    private BookStateDao bookStateDao;
    @Transactional
    @Override
    public String excute(HttpServletRequest request, BookBorrow bookBor, Book bookId, Page page, MultipartFile file) throws Wrong {
        //获取相应id的book对象
        Book book = bookDao.select_by_id(bookId);
        if(book == null){
            throw new Wrong("查无此书！");
        }
        //获取相应的user账号
        Long user_id = SessionUtil.getUserId(request);
        //获取User对象
        User user = userDao.select_by_id(user_id);
        //获取UserCategory对象
        UserCategory userCategory = userCategoryDao.select(user.getUser_category_id());
        //获取BookState对象
        BookState book_state = bookStateDao.select(StringUtil.getBorrowing());
        //获取书籍余量
        Long count = book.getBooks();
        //获取当前日期和30天后的日期
        Date borrow_date = new Date();
        Date borrow_final_date = DateUtil.getDate(borrow_date, LongUtil.getBorrow_date());
        //判断余量是否足够
        if(count>=1){
            //判断是否是在黑名单
            if(userDao.blacklist(user_id).equals("0")){
                BookBorrow bookBorrow = new BookBorrow.Builder()
                        .book(book)
                        .user(user)
                        .userCategory(userCategory)
                        .borrow_date(borrow_date)
                        .borrow_final_date(borrow_final_date)
                        .bookState(book_state)
                        .build();
                Book book_update_like = new Book.Builder()
                        .book_id(book.getBook_id())
                        .book_user_num(book.getBook_user_num()+1L)
                        .build();
                //判断是否更新和添加成功和借阅次数
                if(borrowDao.insert(bookBorrow)==1 &&
                        bookDao.update_books(count-1L,book.getBook_id())==1 &&
                        bookDao.update_book_user_num(book_update_like)==1){
                    return StringUtil.getBorrow_success();
                }
                throw new Wrong(StringUtil.getBorrow_fail());
            }
            throw new Wrong(StringUtil.getBorrow_system_error()) ;
        }
        throw new Wrong(StringUtil.getNot_enough());
    }
}
