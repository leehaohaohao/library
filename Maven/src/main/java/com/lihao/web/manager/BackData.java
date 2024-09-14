package com.lihao.web.manager;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.ResponsePack;
import com.lihao.service.DataService;
import com.lihao.web.BaseServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/data")
public class BackData extends BaseServlet {
    @Autowired
    private DataService dataServiceImpl;
    @RequestMapping("/borrow/nums")
    public ResponsePack borrowNums(Integer page_num){
        return getSuccessResponsePack(new PageInfo<>(dataServiceImpl.numList(page_num)));
    }
    @RequestMapping("/blacklist")
    public ResponsePack blacklist(Integer page_num){
        return getSuccessResponsePack(new PageInfo<>(dataServiceImpl.sc(page_num)));
    }
    @RequestMapping("/book/category")
    public ResponsePack bookCategory(){
        return getSuccessResponsePack(dataServiceImpl.bc());
    }
}
