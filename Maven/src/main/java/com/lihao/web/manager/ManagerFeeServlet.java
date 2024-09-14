package com.lihao.web.manager;

import com.lihao.bean.ResponsePack;
import com.lihao.exception.Wrong;
import com.lihao.service.ManagerFeeService;
import com.lihao.web.BaseServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/fee")
public class ManagerFeeServlet extends BaseServlet {
    @Autowired
    private ManagerFeeService feeServiceImpl;
    @RequestMapping("/unpaid")
    public ResponsePack unpaid(Integer page_num){
        return getSuccessResponsePack(feeServiceImpl.select(page_num,3L));
    }
    @RequestMapping("/paid")
    public ResponsePack paid(Integer page_num){
        return getSuccessResponsePack(feeServiceImpl.select(page_num,2L));
    }
    @RequestMapping("/withdraw")
    public ResponsePack withdraw(Long fee_id) throws Wrong {
        return getSuccessResponsePack(feeServiceImpl.withdraw(fee_id));
    }
}
