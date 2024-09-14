package com.lihao.dao;

import com.lihao.bean.Author;
import org.apache.ibatis.annotations.*;

public interface AuthorDao {
    Author select(Long author_id);

    Author select_author(String author);
    @Insert("insert into t_author (author) values (#{author})")
    int insert_author(String author);
}
