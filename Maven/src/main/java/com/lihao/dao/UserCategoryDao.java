package com.lihao.dao;

import com.lihao.bean.UserCategory;
import org.springframework.stereotype.Repository;

public interface UserCategoryDao {
    UserCategory select(Long user_category_id);
}
