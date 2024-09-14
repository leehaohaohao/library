package com.lihao.service.serviceImpl.feeService;

import com.lihao.bean.Fee;
import com.lihao.bean.Page;
import com.lihao.dao.FeeDao;
import com.lihao.exception.Wrong;
import com.lihao.service.FeeService;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
@Transactional
@Service
public class FeePayService implements FeeService<String> {
    @Autowired
    private FeeDao feeDao;
    @Override
    public String excute(HttpServletRequest request, Page page, Fee fee) throws Wrong {
        if(feeDao.select_by_fee_id(fee.getFee_id()).getFee_state_id()!=3){
            throw new Wrong("你已经缴纳，请勿重复操作！");
        }
        if(feeDao.update_fee_state_id(fee)!=1){
            throw new Wrong(StringUtil.getFee_pay_fail());
        }
        return StringUtil.getFee_pay_success();
    }
}
