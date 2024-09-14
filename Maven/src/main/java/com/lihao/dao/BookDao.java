package com.lihao.dao;

import com.lihao.bean.Book;
import com.lihao.bean.excute.BookCategoryNums;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookDao {
    List<Book> select();
    List<Book> select_rank();
    int update_books(@Param("books") Long books,@Param("book_id") Long book_id);
    int update_book_user_num(Book book);
    Book select_by_id(Book book);
    List<Book> select_by_query(String query);
    @Insert("insert into t_book (author_id,category_id,press_id,book,book_photo,books,book_user_num,book_money,bookshelf)" +
            "values (#{author.author_id},#{category.category_id},#{press.press_id},#{book},#{book_photo},#{books},#{book_user_num},#{book_money},#{bookshelf})")
    int insert_book(Book book);
    List<Book> select_book_by_name(String book_name);
    int update_book_is_delete_by_id(@Param("is_delete") boolean is_delete, @Param("book_id") Long book_id);
    int update_book(Book book);
    List<BookCategoryNums> bc();
}
