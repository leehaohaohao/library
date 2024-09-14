package com.lihao.service.serviceImpl.bookService;

import com.lihao.bean.Author;
import com.lihao.bean.Book;
import com.lihao.bean.BookCategory;
import com.lihao.bean.Press;
import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.dao.CategoryDao;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import com.lihao.service.serviceImpl.serviceUtil.AuthorServiceUtil;
import com.lihao.service.serviceImpl.serviceUtil.PressServiceUtil;
import com.lihao.utils.FileUtil;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookUpdateService implements BookService<String> {
    @Autowired
    private AuthorServiceUtil authorServiceUtil;
    @Autowired
    private PressServiceUtil pressServiceUtil;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public String excute(BookExcute bookExcute) throws Wrong {
        String aname = null;
        String pname = null;
        Long category_id = null;
        if(bookExcute.getBook().getAuthor()!=null){
            aname = bookExcute.getBook().getAuthor().getAuthor();
        }
        if(bookExcute.getBook().getPress()!=null){
            pname = bookExcute.getBook().getPress().getPress();
        }
        if(bookExcute.getBook().getCategory()!=null){
            category_id =bookExcute.getBook().getCategory().getCategory_id();
        }
        Author author = null;
        Press press = null;
        BookCategory bookCategory =null;
        String book_photo = null;
        String[] ss=null;
        if(category_id!=null){
            bookCategory = categoryDao.select_by_id(category_id);
        }
        if(aname!=null && !aname.isEmpty()){
            author = authorServiceUtil.authorHandle(aname);
        }
        if(pname!=null && !pname.isEmpty()){
            press = pressServiceUtil.pressHandle(pname);
        }
        if(bookExcute.getFile()!=null){
            ss = FileUtil.fileBookLoad(bookExcute.getFile(),StringUtil.getBook_root());
            if(ss!=null && ss.length>=2){
                book_photo=ss[0];
            }
        }
        Book book = new Book.Builder()
                .book_id(bookExcute.getBook().getBook_id())
                .books(bookExcute.getBook().getBooks())
                .category(bookCategory)
                .press(press)
                .author(author)
                .bookshelf(bookExcute.getBook().getBookshelf())
                .book_money(bookExcute.getBook().getBook_money())
                .book(bookExcute.getBook().getBook())
                .book_photo(book_photo)
                .build();
        /*System.out.println(book);*/
        if(bookDao.update_book(book)==1){
            return StringUtil.getUpdate_success();
        }else{
            if(ss!=null){
                FileUtil.removeFile(ss[1]);
            }
            throw new Wrong(StringUtil.getUpdate_fail());
        }
    }
}
