package com.lihao.dao;

import com.lihao.bean.Fee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


public interface FeeDao {
    int insert(Fee fee);
    List<Fee> select_by_user_id(Long user_id);
    BigDecimal[] select_fee_num(Long user_id);
    Integer update_fee_state_id(Fee fee);
    List<Fee> select_unpaid(Long fee_state_id);
    Fee select_by_fee_id(Long fee_id);
}
