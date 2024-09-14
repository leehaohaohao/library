package com.lihao.dao;

import com.lihao.bean.FeeState;
import org.springframework.stereotype.Repository;


public interface FeeStateDao {
    FeeState select(Long fee_state_id);
}
