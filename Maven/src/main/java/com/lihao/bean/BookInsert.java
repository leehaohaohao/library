package com.lihao.bean;

import java.math.BigDecimal;

public class BookInsert {
    private Long books;
    private String book;
    private String author;
    private String press;
    private String category;
    private String bookshelf;
    private BigDecimal book_money;
    public BookInsert() {
    }

    @Override
    public String toString() {
        return "BookInsert{" +
                "books=" + books +
                ", book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", category='" + category + '\'' +
                ", bookshelf='" + bookshelf + '\'' +
                ", book_money=" + book_money +
                '}';
    }

    public Long getBooks() {
        return books;
    }

    public void setBooks(Long books) {
        this.books = books;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




    public String getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(String bookshelf) {
        this.bookshelf = bookshelf;
    }

    public BigDecimal getBook_money() {
        return book_money;
    }

    public void setBook_money(BigDecimal book_money) {
        this.book_money = book_money;
    }

}
