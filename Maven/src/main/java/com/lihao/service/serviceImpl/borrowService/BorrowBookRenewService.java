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
@Service("borrowBookRenewService")
public class BorrowBookRenewService implements BorrowService<String> {
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private UserDao userDao;
    @Override
    public String excute(HttpServletRequest request, BookBorrow bookBorrow, Book book,Page page,MultipartFile file) throws Wrong {
        Long user_id = SessionUtil.getUserId(request);
        BookBorrow bookBorrow1 = borrowDao.select_book_borrowed(bookBorrow);
        //获取借阅订单id
        Long borrow_id =bookBorrow1.getBorrow_id();
        //更新日期
        if(borrowDao.update_borrow_final_date(new Date(),bookBorrow1.getBorrow_id())!=1){
            throw new Wrong(StringUtil.getBook_renew_fail());
        }
        //判断是否在黑名单，否则无法续借
        if(userDao.blacklist(user_id).equals("0")){
            Date borrow_final_date = bookBorrow1.getBorrow_final_date();
            borrow_final_date = DateUtil.getDate(borrow_final_date,LongUtil.getRenew_date());
            if(borrowDao.update_borrow_final_date(borrow_final_date,borrow_id)==1
                    &&borrowDao.update_book_state_id(borrow_id,LongUtil.getBorrowing())==1){
                return StringUtil.getBook_renew_success();
            }
        }
        throw new Wrong(StringUtil.getBook_renew_fail());
    }
}
