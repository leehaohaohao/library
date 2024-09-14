package com.lihao.dao;

import com.lihao.bean.BookState;
import org.springframework.stereotype.Repository;


public interface BookStateDao {
    BookState select(String str);
}
