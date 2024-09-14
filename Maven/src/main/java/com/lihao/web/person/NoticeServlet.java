package com.lihao.web.person;

import com.lihao.bean.Notice;
import com.lihao.bean.ResponsePack;
import com.lihao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class NoticeServlet {
    @Autowired
    @Qualifier("noticeServiceImpl")
    private NoticeService noticeServiceImpl;

    @RequestMapping("/filter1/notice/select")
    public ResponsePack<List<Notice>> doNotice_select(HttpServletRequest request) {
        ResponsePack<List<Notice>> responsePack = new ResponsePack<>();
        responsePack.setData(noticeServiceImpl.list());
        responsePack.setSuccess(true);
        return responsePack;
    }
}