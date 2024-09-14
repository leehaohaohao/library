package com.lihao.web.manager;

import com.lihao.bean.*;
import com.lihao.bean.excute.BookExcute;
import com.lihao.dao.BookDao;
import com.lihao.excelHandler.BookHandler;
import com.lihao.exception.Wrong;
import com.lihao.service.BookService;
import com.lihao.decorator.BookDecorator;
import com.lihao.utils.ExcelUtil;
import com.lihao.web.BaseServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/manager/book")
public class ManagerBookServlet extends BaseServlet {
    @Autowired
    @Qualifier("bookInsertService")
    private BookService<String> bookInsertService;
    @Autowired
    @Qualifier("bookDeleteService")
    private BookService<String> bookDeleteService;
    @Autowired
    @Qualifier("bookSelectService")
    private BookService<Book> bookSelectService;
    @Autowired
    @Qualifier("bookUpdateService")
    private BookService<String> bookUpdateService;
    @Autowired
    private BookDao bookDao;
    @RequestMapping("/insert")
    public ResponsePack<String> Book_Insert(String category, String book,
                                            String books,String author,
                                            String press,Long book_money,
                                            String bookshelf ,MultipartFile file, HttpServletRequest request) throws Wrong {
        BookInsert bookInsert = new BookInsert();
        bookInsert.setCategory(category);
        bookInsert.setBooks(Long.valueOf(books));
        bookInsert.setBook(book);
        bookInsert.setAuthor(author);
        bookInsert.setPress(press);
        bookInsert.setBook_money(BigDecimal.valueOf(book_money));
        bookInsert.setBookshelf(bookshelf);

        // 检查每个字段是否为空
        if (bookInsert.getAuthor() == null || bookInsert.getAuthor().isEmpty() ||
                bookInsert.getPress() == null || bookInsert.getPress().isEmpty() ||
                bookInsert.getCategory() == null || bookInsert.getCategory().isEmpty() ||
                bookInsert.getBook() == null || bookInsert.getBook().isEmpty() ||
                bookInsert.getBookshelf() == null || bookInsert.getBookshelf().isEmpty() ||
                bookInsert.getBooks() == null ||
                file.isEmpty() ||
                bookInsert.getBook_money() == null) {
            throw new Wrong("请填写所有字段！");
        }
        Author _author = new Author(null,bookInsert.getAuthor());
        Press _press = new Press(null, bookInsert.getPress());
        BookCategory bookCategory = new BookCategory(Long.parseLong(bookInsert.getCategory()), null);
        Book _book = new Book.Builder()
                .book(bookInsert.getBook())
                .bookshelf(bookInsert.getBookshelf())
                .books(bookInsert.getBooks())
                .book_money(bookInsert.getBook_money())
                .book_user_num(0L)
                .author(_author)
                .press(_press)
                .category(bookCategory)
                .build();
        BookExcute bookExcute = new BookExcute.Builder()
                .book(_book)
                .file(file)
                .request(request)
                .build();
        BookDecorator<String> bookDecorator = new BookDecorator<>(bookInsertService,false);
        return getSuccessResponsePack(bookDecorator.excute(bookExcute));
    }
    @RequestMapping("/delete")
    public ResponsePack<String> Book_delete(@RequestBody BookExcute bookExcute) throws Wrong {
        BookDecorator<String> bookDecorator = new BookDecorator<>(bookDeleteService,false);
        return getSuccessResponsePack(bookDecorator.excute(bookExcute));
    }
    @RequestMapping("/select")
    public ResponsePack<Book> Book_select(@RequestParam Long book_id) throws Wrong {
        Book book = new Book.Builder()
                .book_id(book_id)
                .build();
        BookExcute bookExcute = new BookExcute.Builder()
                .book(book)
                .build();
        BookDecorator<Book> bookDecorator = new BookDecorator<>(bookSelectService,false);
        Book book1;
        book1 = bookDecorator.excute(bookExcute);
        if(book1==null){
            throw new Wrong("服务器异常，请联系管理员处理！");
        }
        return getSuccessResponsePack(book1);
    }

    @RequestMapping("/update")
    public ResponsePack<String> Book_update(String book,String author,String press,Long category,
            String bookshelf,Long book_id , BigDecimal book_money , Long books, @RequestPart(value = "file" , required = false)MultipartFile file) throws Wrong {
        Book _book = new Book();
        _book.setBook_id(book_id);
        if(author!=null && !author.isEmpty()){
            Author _author = new Author();
            _author.setAuthor(author);
            _book.setAuthor(_author);
        }
        if(press!=null && !press.isEmpty()){
            Press _press = new Press();
            _press.setPress(press);
            _book.setPress(_press);
        }
        if(category!=null){
            BookCategory bookCategory = new BookCategory();
            bookCategory.setCategory_id(category);
            _book.setCategory(bookCategory);
        }
        if(books!=null){
            _book.setBooks(books);
        }
        if(book!=null && !book.isEmpty()){
            _book.setBook(book);
        }
        if(book!=null && !bookshelf.isEmpty()){
            _book.setBookshelf(bookshelf);
        }
        if(book_money!=null && !book_money.equals(BigDecimal.ZERO)){
            _book.setBook_money(book_money);
        }
        BookExcute bookExcute = new BookExcute.Builder()
                .book(_book)
                .file(file)
                .build();
        System.out.println(bookExcute);
        BookDecorator<String> bookDecorator = new BookDecorator<>(bookUpdateService,false);
        return getSuccessResponsePack(bookDecorator.excute(bookExcute));
    }
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws InstantiationException, IllegalAccessException, Wrong, IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=Books.xls");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String[] names = new String[]{"书籍编号","书名","作者","出版社","类别","书架位置","价值","照片链接","用户借阅数","库存"};
        ExcelUtil<Book> excelUtil = new ExcelUtil(BookHandler.class);
        List<Book> bookList = bookDao.select_rank();
        Workbook workbook = excelUtil.deal("Books",bookList,names);
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
