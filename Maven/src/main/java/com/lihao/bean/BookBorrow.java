package com.lihao.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookBorrow {
    private Long borrow_id;
    private Book book;
    private Date borrow_date;
    private Date borrow_final_date;
    private UserCategory userCategory;
    private User user;
    private BookState bookState;
    private Date book_return_date;
    private String book_return_photo;
    private BookReturnState bookReturnState;
    public BookBorrow(){}

    @Override
    public String toString() {
        return "BookBorrow{" +
                "borrow_id=" + borrow_id +
                ", book=" + book +
                ", borrow_date=" + borrow_date +
                ", borrow_final_date=" + borrow_final_date +
                ", userCategory=" + userCategory +
                ", user=" + user +
                ", bookState=" + bookState +
                ", book_return_date=" + book_return_date +
                ", book_return_photo='" + book_return_photo + '\'' +
                ", bookReturnState=" + bookReturnState +
                '}';
    }

    public void setBook_return_photo(String book_return_photo) {
        this.book_return_photo = book_return_photo;
    }

    public Long getBorrow_id() {
        return borrow_id;
    }

    public Book getBook() {
        return book;
    }
    public Long getBook_id(){
        if(book==null){
            return null;
        }
        return book.getBook_id();
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public Date getBorrow_final_date() {
        return borrow_final_date;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }
    public Long getUser_category_id(){
        if(userCategory==null){
            return null;
        }
        return userCategory.getUser_category_id();
    }

    public User getUser() {
        return user;
    }
    public Long getUser_id(){
        if(user==null){
            return null;
        }
        return user.getUser_id();
    }
    public BookState getBookState() {
        return bookState;
    }
    public Long getBook_state_id(){
        if(bookState == null){
            return null;
        }
        return bookState.getBook_state_id();
    }

    public Date getBook_return_date() {
        return book_return_date;
    }

    public String getBook_return_photo() {
        return book_return_photo;
    }

    public BookReturnState getBookReturnState() {
        return bookReturnState;
    }
    public Long getReturn_state_id(){

        if(bookReturnState==null) {
            return null;
        }
        return bookReturnState.getReturn_state_id();
    }
    public String getReturn_state(){
        if(bookReturnState==null){
            return null;
        }
        return bookReturnState.getReturn_state();
    }
    private BookBorrow (Builder builder){
        this.borrow_id= builder.borrow_id;
        this.book= builder.book;
        this.bookState = builder.bookState;
        this.borrow_date= builder.borrow_date;
        this.borrow_final_date= builder.borrow_final_date;
        this.user= builder.user;
        this.userCategory= builder.userCategory;
        this.bookReturnState=builder.bookReturnState;
        this.book_return_date=builder.book_return_date;
        this.book_return_photo=builder.book_return_photo;
    }
    public static class Builder{
        private Long borrow_id;
        private Book book;
        private Date borrow_date;
        private Date borrow_final_date;
        private UserCategory userCategory;
        private User user;
        private BookState bookState;
        private Date book_return_date;
        private String book_return_photo;
        private BookReturnState bookReturnState;
        public Builder borrow_id(Long borrow_id){
            this.borrow_id=borrow_id;
            return this;
        }
        public Builder book(Book book){
            this.book=book;
            return this;
        }
        public Builder borrow_date(Date borrow_date){
            this.borrow_date=borrow_date;
            return this;
        }
        public Builder borrow_final_date(Date borrow_final_date){
            this.borrow_final_date=borrow_final_date;
            return this;
        }
        public Builder userCategory(UserCategory userCategory){
            this.userCategory=userCategory;
            return this;
        }
        public Builder user(User user){
            this.user=user;
            return this;
        }
        public Builder bookState(BookState bookState){
            this.bookState= bookState;
            return this;
        }
        public Builder book_return_date(Date book_return_date){
            this.book_return_date=book_return_date;
            return this;
        }
        public Builder book_return_photo(String book_return_photo){
            this.book_return_photo=book_return_photo;
            return this;
        }
        public Builder bookReturnState(BookReturnState bookReturnState){
            this.bookReturnState=bookReturnState;
            return this;
        }
        public BookBorrow build(){
            return new BookBorrow(this);
        }
    }
}
