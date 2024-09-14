package com.lihao.service.serviceImpl.borrowService;

import com.lihao.bean.Book;
import com.lihao.bean.BookBorrow;
import com.lihao.bean.Page;
import com.lihao.bean.User;
import com.lihao.dao.BorrowDao;
import com.lihao.dao.UserDao;
import com.lihao.service.BorrowService;
import com.lihao.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Transactional
@Service("borrowBookListService")
public class BorrowBookListService implements BorrowService<List<BookBorrow>> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BorrowDao borrowDao;
    @Override
    public List<BookBorrow> excute(HttpServletRequest request, BookBorrow bookBor, Book book, Page page, MultipartFile file) {
        Long user_id = SessionUtil.getUserId(request);
        User user = userDao.select_by_id(user_id);
        BookBorrow bookBorrow = new BookBorrow.Builder()
                .user(user)
                .build();
        List<BookBorrow> bookBorrowList = borrowDao.select_book_borrowed_all(bookBorrow);
        boolean success = true;
        //在借阅订单里进行逾期归还书籍处理
        for(BookBorrow bookBorrow1:bookBorrowList){
            Date returnDate = bookBorrow1.getBorrow_final_date();
            LocalDate localDate = returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate today = LocalDate.now();
            if(localDate.isBefore(today) && bookBorrow1.getBook_state_id()!=3L){
                if(borrowDao.update_book_state_id(bookBorrow1.getBorrow_id(),3L)==1){
                    /*System.out.println(bookBorrow1);*/
                    continue;
                }
                success=false;
            }
        }
        if(success){
            return bookBorrowList;
        }
        return null;
    }
}
