package com.lihao.service.serviceImpl.categoryService;

import com.lihao.bean.BookCategory;
import com.lihao.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements com.lihao.service.CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<BookCategory> select_all_category() {
        return categoryDao.select_all_category();
    }
}
