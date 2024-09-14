package com.lihao.service.serviceImpl.feeService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Fee;
import com.lihao.bean.FeeState;
import com.lihao.bean.Page;
import com.lihao.dao.FeeDao;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerFeeServiceImpl implements ManagerFeeService {
    @Autowired
    private FeeDao feeDao;
    @Override
    public List<Fee> select(Integer page_num,Long fee_state_id) {
        return feeDao.select_unpaid(fee_state_id);
    }

    @Override
    public String withdraw(Long fee_id) throws Wrong {
        FeeState feeState = new FeeState(1L,null);
        Fee fee = new Fee.Builder().fee_id(fee_id).feeState(feeState).builder();
        if(feeDao.update_fee_state_id(fee)==1){
            return "撤销成功！";
        }
        throw new Wrong("撤销失败！");
    }
}
