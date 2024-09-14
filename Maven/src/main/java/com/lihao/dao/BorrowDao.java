package com.lihao.dao;

import com.lihao.bean.BookBorrow;
import com.lihao.bean.excute.BorrowNumsBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface BorrowDao {
    int insert(BookBorrow bookBorrow);
    List<BookBorrow> select_book_borrowed_all(BookBorrow bookBorrow);
    BookBorrow select_book_borrowed(BookBorrow bookBorrow);
    int update_book_state_id(@Param("borrow_id") Long borrow_id,
                             @Param("book_state_id") Long book_state_id);
    int update_book_return(@Param("borrow_id") Long borrow_id, @Param("book_state_id") Long book_state_id,
                           @Param("book_return_date")Date book_return_date, @Param("book_return_photo") String book_return_photo,
                           @Param("return_state_id") Long return_state_id);
    int update_borrow_final_date(@Param("borrow_final_date") Date borrow_final_date,
                                 @Param("borrow_id") Long borrow_id);
    List<BookBorrow> select_book_borrowed_history(Long user_id);
    List<BookBorrow> bookReturn();
    List<BorrowNumsBean> nums();
}
