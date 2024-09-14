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
@Service("borrowBookReturnService")
public class BorrowBookReturnService implements BorrowService<String> {
    @Autowired
    private BorrowDao borrowDao;
    @Override
    public String excute(HttpServletRequest request, BookBorrow bookBorrow, Book book, Page page, MultipartFile file) throws Wrong {
        BookBorrow bookBorrow1 = borrowDao.select_book_borrowed(bookBorrow);
        //还书成功，对状态更新成还书中
        if(borrowDao.update_book_state_id(bookBorrow1.getBorrow_id(),LongUtil.getReturning())!=1){
            throw new Wrong(StringUtil.getBook_return_fail());
        }
        /*if(file == null){
            throw new Wrong("未上传图片！");
        }
        String[] ss = null;
        ss=FileUtil.fileBookLoad(file,StringUtil.getBook_root());
        if(ss ==null || ss.length!=2){
            throw new Wrong("服务器出现异常，请联系管理员处理！");
        }
        bookBorrow1.setBook_return_photo(ss[0]);*/
        if(bookBorrow1.getBook_return_date()==null){
            if(borrowDao.update_book_return(bookBorrow1.getBorrow_id(),null,null,null,LongUtil.getProcess())==1){
                return StringUtil.getBook_return_success();
            }
        }
        /*if(ss!=null && ss.length==2){
            FileUtil.removeFile(ss[1]);
        }*/
        throw new Wrong(StringUtil.getBook_return_fail());
    }
}
