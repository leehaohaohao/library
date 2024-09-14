package com.lihao.dao;

import com.lihao.bean.BookReturnState;
import org.springframework.stereotype.Repository;


public interface BookReturnStateDao {
    BookReturnState select(Long return_state_id);
}
