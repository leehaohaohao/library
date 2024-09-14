package com.lihao.decorator;

import com.lihao.bean.*;
import com.lihao.config.SpringConfig;
import com.lihao.dao.*;
import com.lihao.exception.Wrong;
import com.lihao.service.BorrowService;
import com.lihao.utils.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class BorrowTimeOutDecorator<T> implements BorrowService<T> {
    private BorrowService<T> borrowService;
    private boolean isCheck;
    private ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public BorrowTimeOutDecorator(BorrowService<T> borrowService, boolean isCheck){
        this.borrowService=borrowService;
        this.isCheck=isCheck;
    }
    @Override
    public T excute(HttpServletRequest request, BookBorrow bookBorrow, Book book,Page page,MultipartFile file) throws Wrong {
        BorrowDao borrowDaoImpl = context.getBean(BorrowDao.class);
        UserDao userDaoImpl = context.getBean(UserDao.class);
        FeeCategoryDao feeCategoryDaoImpl = context.getBean(FeeCategoryDao.class);
        FeeStateDao feeStateDaoImpl = context.getBean(FeeStateDao.class);
        FeeDao feeDaoImpl = context.getBean(FeeDao.class);
        BookBorrow bookBorrow1 = null;
        if(bookBorrow!=null){
            bookBorrow1 = borrowDaoImpl.select_book_borrowed(bookBorrow);
        }
        if(isCheck&&isTimeOut(bookBorrow1)){
            Date borrow_final_date = bookBorrow1.getBorrow_final_date();
            Long user_id = SessionUtil.getUserId(request);
            User user = userDaoImpl.select_by_id(user_id);
            FeeCategory feeCategory = feeCategoryDaoImpl.select(LongUtil.getFee_overrun());
            FeeState feeState = feeStateDaoImpl.select(LongUtil.getFee_unpaid());
            Fee fee = new Fee.Builder()
                    .fee_num(FeeUtil.getFee(borrow_final_date))
                    .feeCategory(feeCategory)
                    .feeState(feeState)
                    .user(user)
                    .book(bookBorrow1.getBook().getBook())
                    .builder();
            if(feeDaoImpl.insert(fee)!=1 ){
                throw new Wrong(StringUtil.getFail());
            }
        }

        return borrowService.excute(request,bookBorrow,book,page,file);
    }

    private boolean isTimeOut(BookBorrow bookBorrow1){
        if(bookBorrow1!=null){
            if(bookBorrow1.getBook_state_id()== LongUtil.getOverrun()){
                return true;
            }
        }
        return false;
    }
}