package com.lihao.service.serviceImpl.borrowService;

import com.lihao.bean.*;
import com.lihao.dao.*;
import com.lihao.exception.Wrong;
import com.lihao.service.BorrowService;
import com.lihao.utils.LongUtil;
import com.lihao.utils.SessionUtil;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@Transactional
@Service("borrowBookLostService")
public class BorrowBookLostService implements BorrowService<String> {
    @Autowired
    private FeeDao feeDao;
    @Autowired
    private FeeCategoryDao feeCategoryDao;
    @Autowired
    private FeeStateDao feeStateDao;
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private UserDao userDao;
    @Override
    public String excute(HttpServletRequest request, BookBorrow bookBor, Book book,Page page,MultipartFile file) throws Wrong {

        BookBorrow bookBorrow = borrowDao.select_book_borrowed(bookBor);
        BigDecimal book_money = bookBorrow.getBook().getBook_money();
        Long user_id = SessionUtil.getUserId(request);
        User user = userDao.select_by_id(user_id);

        FeeCategory feeCategory = feeCategoryDao.select(LongUtil.getFee_lost());
        FeeState feeState = feeStateDao.select(LongUtil.getFee_unpaid());
        Fee fee = new Fee.Builder()
                .user(user)
                .fee_num(book_money)
                .feeState(feeState)
                .feeCategory(feeCategory)
                .book(bookBorrow.getBook().getBook())
                .builder();
        if(feeDao.insert(fee)!=1 || borrowDao.update_book_state_id(bookBor.getBorrow_id(),LongUtil.getNull())!=1){
            throw new Wrong(StringUtil.getBook_lost_fail());

        }
        return StringUtil.getBook_lost_success();
    }
}
