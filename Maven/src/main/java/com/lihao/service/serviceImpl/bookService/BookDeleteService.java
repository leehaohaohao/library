package com.lihao.service.serviceImpl.bookService;

import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookDeleteService implements BookService<String> {
    @Autowired
    private BookDao bookDao;
    @Override
    public String excute(BookExcute bookExcute) throws Wrong {
        for(Long book_id: bookExcute.getBook_ids()){
            if(bookDao.update_book_is_delete_by_id(true,book_id)!=1){
                throw new Wrong(StringUtil.getDelete_fail());
            }
        }
        return StringUtil.getDelete_success();
    }
}
