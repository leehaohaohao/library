package com.lihao.service.serviceImpl.bookService;

import com.lihao.bean.*;
import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.dao.CategoryDao;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import com.lihao.service.serviceImpl.serviceUtil.AuthorServiceUtil;
import com.lihao.service.serviceImpl.serviceUtil.PressServiceUtil;
import com.lihao.utils.FileUtil;
import com.lihao.utils.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Transactional
@Service
public class BookInsertService implements BookService<String> {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private AuthorServiceUtil authorServiceUtil;
    @Autowired
    private PressServiceUtil pressServiceUtil;
    @Override
    public String excute(BookExcute bookExcute) throws Wrong {
        Book book = bookExcute.getBook();
        MultipartFile file = bookExcute.getFile();
        List<Book> books = bookDao.select_book_by_name(book.getBook());
        BookCategory bookCategory = categoryDao.select_by_id(book.getCategory().getCategory_id());
        if(bookCategory==null){
            throw new Wrong(StringUtil.getInsert_fail());
        }
        String pre = book.getPress().getPress();
        String aut = book.getAuthor().getAuthor();
        //判断是否有重名书籍
        if(books!=null){
            for(Book book1:books){
                if(pre.equals(book1.getPress().getPress())&&aut.equals(book1.getAuthor().getAuthor())){
                    Long book_num = book1.getBooks()+book.getBooks();
                    if(bookDao.update_books(book_num,book1.getBook_id())==1){
                        return StringUtil.getInsert_success();
                    }
                }
            }
        }
        //重名但作者或出版社不同
        Press press = pressServiceUtil.pressHandle(pre);
        Author author = authorServiceUtil.authorHandle(aut);

        book.setAuthor(author);
        book.setPress(press);
        book.setCategory(bookCategory);
        String[] ss = FileUtil.fileBookLoad(file,StringUtil.getBook_root());
        String book_photo = ss[0];
        if(book_photo==null){
            throw new Wrong(StringUtil.getInsert_fail());
        }
        book.setBook_photo(book_photo);
        if(bookDao.insert_book(book)==1){
            return StringUtil.getInsert_success();
        }else{
            FileUtil.removeFile(ss[1]);
            throw new Wrong(StringUtil.getInsert_fail());
        }
    }
}
