package com.lihao.service;

import com.lihao.bean.Fee;
import com.lihao.exception.Wrong;

import java.util.List;

public interface ManagerFeeService {
    List<Fee> select(Integer page_num,Long fee_state_id);
    String withdraw(Long fee_id) throws Wrong;
}
