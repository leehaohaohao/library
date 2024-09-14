package com.lihao.bean.excute;

import com.lihao.bean.Book;
import com.lihao.bean.Page;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class BookExcute {
    private String query;
    private Page page;
    private Book book;
    private MultipartFile file;
    private HttpServletRequest request;
    private Long[] book_ids;

    public String getQuery() {
        return query;
    }

    public Page getPage() {
        return page;
    }

    public Book getBook() {
        return book;
    }

    public MultipartFile getFile() {
        return file;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public Long[] getBook_ids() {
        return book_ids;
    }

    public BookExcute() {
    }

    private BookExcute(Builder builder) {
        this.query = builder.query;
        this.page = builder.page;
        this.book = builder.book;
        this.file = builder.file;
        this.request = builder.request;
        this.book_ids = builder.book_ids;
    }

    public static class Builder {
        private String query;
        private Page page;
        private Book book;
        private MultipartFile file;
        private HttpServletRequest request;
        private Long[] book_ids;

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder page(Page page) {
            this.page = page;
            return this;
        }

        public Builder book(Book book) {
            this.book = book;
            return this;
        }

        public Builder file(MultipartFile file) {
            this.file = file;
            return this;
        }

        public Builder request(HttpServletRequest request) {
            this.request = request;
            return this;
        }

        public Builder bookIds(Long[] book_ids) {
            this.book_ids = book_ids;
            return this;
        }

        public BookExcute build() {
            return new BookExcute(this);
        }
    }

    @Override
    public String toString() {
        return "BookExcute{" +
                "query='" + query + '\'' +
                ", page=" + page +
                ", book=" + book +
                ", file=" + file +
                ", request=" + request +
                ", book_ids=" + Arrays.toString(book_ids) +
                '}';
    }
}
