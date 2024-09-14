package com.lihao.service;

import com.lihao.bean.BookCategory;

import java.util.List;

public interface CategoryService {
    List<BookCategory> select_all_category();
}
