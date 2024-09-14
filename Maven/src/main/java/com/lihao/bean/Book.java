package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    private Long books;
    private Long book_id;
    private String book;
    private Author author;
    private Press press;
    private BookCategory category;
    private String book_photo;
    private Long book_user_num;
    private String bookshelf;
    private BigDecimal book_money;
    public Book(){}

    public Long getBooks() {
        return books;
    }

    public Long getBook_id() {
        return book_id;
    }

    public String getBook() {
        return book;
    }

    public Author getAuthor() {
        return author;
    }

    public Press getPress() {
        return press;
    }

    public BookCategory getCategory() {
        return category;
    }
    public Long getBook_user_num(){
        return book_user_num;
    }

    public String getBook_photo() {
        return book_photo;
    }

    public String getBookshelf() {
        return bookshelf;
    }

    public BigDecimal getBook_money() {
        return book_money;
    }

    public void setBooks(Long books) {
        this.books = books;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPress(Press press) {
        this.press = press;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public void setBook_photo(String book_photo) {
        this.book_photo = book_photo;
    }

    public void setBook_user_num(Long book_user_num) {
        this.book_user_num = book_user_num;
    }

    public void setBookshelf(String bookshelf) {
        this.bookshelf = bookshelf;
    }

    public void setBook_money(BigDecimal book_money) {
        this.book_money = book_money;
    }

    @Override
    public String toString() {
        return "Book{" +
                "books=" + books +
                ", book_id=" + book_id +
                ", book='" + book + '\'' +
                ", author=" + author +
                ", press=" + press +
                ", category=" + category +
                ", book_photo='" + book_photo + '\'' +
                ", book_user_num=" + book_user_num +
                ", bookshelf='" + bookshelf + '\'' +
                ", book_money=" + book_money +
                '}';
    }

    private Book (Builder builder){
        this.book_id=builder.book_id;
        this.book=builder.book;
        this.author=builder.author;
        this.press=builder.press;
        this.category= builder.category;
        this.book_photo= builder.book_photo;
        this.bookshelf= builder.bookshelf;
        this.book_user_num=builder.book_user_num;
        this.books=builder.books;
        this.book_money=builder.book_money;
    }
    public static class Builder{
        private Long book_id;
        private String book;
        private Author author;
        private Press press;
        private BookCategory category;
        private String book_photo;
        private Long book_user_num;
        private String bookshelf;
        private Long books;
        private BigDecimal book_money;
        public Builder books(Long books){
            this.books = books;
            return this;
        }
        public Builder book_user_num(Long book_user_num){
            this.book_user_num=book_user_num;
            return this;
        }
        public Builder book_id(Long book_id){
            this.book_id=book_id;
            return this;
        }
        public Builder book(String book){
            this.book=book;
            return this;
        }
        public Builder author(Author author){
            this.author=author;
            return this;
        }
        public Builder press(Press press){
            this.press=press;
            return this;
        }
        public Builder category(BookCategory category){
            this.category=category;
            return this;
        }
        public Builder book_photo(String book_photo){
            this.book_photo=book_photo;
            return this;
        }
        public Builder bookshelf(String bookshelf){
            this.bookshelf=bookshelf;
            return this;
        }
        public Builder book_money(BigDecimal book_money){
            this.book_money=book_money;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
