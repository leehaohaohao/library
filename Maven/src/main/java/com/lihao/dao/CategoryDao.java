package com.lihao.dao;

import com.lihao.bean.BookCategory;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryDao {
    List<BookCategory> select_all_category();
    BookCategory select_by_name(String category);
    BookCategory select_by_id(Long category_id);
}
