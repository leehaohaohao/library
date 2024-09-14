package com.lihao.dao;

import com.lihao.bean.FeeCategory;
import org.springframework.stereotype.Repository;


public interface FeeCategoryDao {
    FeeCategory select(Long fee_category_id);
}
