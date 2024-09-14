package com.lihao.web.person;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Fee;
import com.lihao.bean.FeeState;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.exception.Wrong;
import com.lihao.service.FeeService;
import com.lihao.decorator.FeeDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class FeeServlet {
    @Autowired
    @Qualifier("feeListService")
    private FeeService<List<Fee>> feeListService;

    @Autowired
    @Qualifier("feePayService")
    private FeeService<String> feePayService;

    @RequestMapping("/filter1/fee/select")
    public ResponsePack<PageInfo<Fee>> doFee_select(HttpServletRequest request, @RequestParam("page_num") int pageNum) throws Wrong {
        Page page = new Page(pageNum);
        FeeDecorator<List<Fee>> feeDecorator = new FeeDecorator<>(feeListService,false);
        ResponsePack<PageInfo<Fee>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(feeDecorator.excute(request,page,new Fee())));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/filter1/fee/pay")
    public ResponsePack<String> doFee_pay(HttpServletRequest request, @RequestParam("fee_id") Long feeId) throws Wrong {
        FeeState feeState = new FeeState(2L,null);
        Fee fee = new Fee.Builder()
                .fee_id(feeId)
                .feeState(feeState)
                .builder();
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(feePayService.excute(request,new Page(0),fee));
        responsePack.setSuccess(true);
        return responsePack;
    }
}
