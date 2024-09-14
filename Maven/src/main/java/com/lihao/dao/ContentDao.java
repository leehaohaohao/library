package com.lihao.dao;

import com.lihao.bean.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentDao {
    List<Content> select_all();
    int insert(Content content);
    int update_like(Content content);
    Long select_like(Long content_id);
}
