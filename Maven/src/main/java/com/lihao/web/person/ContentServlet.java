package com.lihao.web.person;

import com.github.pagehelper.PageInfo;
import com.lihao.bean.Content;
import com.lihao.bean.Page;
import com.lihao.bean.ResponsePack;
import com.lihao.decorator.ContentDecorator;
import com.lihao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ContentServlet {
    @Autowired
    @Qualifier("contentListService")
    private ContentService<List<Content>> contentListService;

    @Autowired
    @Qualifier("contentPublishService")
    private ContentService<Integer> contentPublishService;

    @Autowired
    @Qualifier("contentLikeIncreaseService")
    private ContentService<Long> contentLikeIncreaseService;

    @Autowired
    @Qualifier("contentLikeDecreaseService")
    private ContentService<Long> contentLikeDecreaseService;

    @RequestMapping("/filter1/content/selectAll")
    public ResponsePack<PageInfo<Content>> doSelectAll(@RequestParam("page_num") int page_num , HttpServletRequest request) {
        Page page = new Page(page_num);
        Content content = new Content();
        ContentDecorator<List<Content>> contentDecorator = new ContentDecorator<>(contentListService,false);
        ResponsePack<PageInfo<Content>> responsePack = new ResponsePack<>();
        responsePack.setData(new PageInfo<>(contentDecorator.excute(request,page,content)));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/filter1/content/insert")
    public ResponsePack<String> doInsert(@RequestParam("content") String con ,
                                         @RequestParam("publish_date") String publish_date, HttpServletRequest request) throws ParseException {
        Content content= new Content.Builder()
                .content(con)
                .publish_date((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse(publish_date))
                .build();
        ContentDecorator<Integer> contentDecorator = new ContentDecorator<>(contentPublishService,false);
        ResponsePack<String> responsePack = new ResponsePack<>();
        responsePack.setData(contentDecorator.excute(request,new Page(0),content) == 1 ? "发布成功！" : "发布失败！");
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/filter1/content/like/increase")
    public ResponsePack<Long> doLikeIncrease(@RequestParam("content_id") Long content_id, HttpServletRequest request) {
        Content content = new Content.Builder()
                .content_id(content_id)
                .build();
        ContentDecorator<Long> contentDecorator = new ContentDecorator<>(contentLikeIncreaseService,false);
        ResponsePack<Long> responsePack = new ResponsePack<>();
        responsePack.setData(contentDecorator.excute(request,new Page(0),content));
        responsePack.setSuccess(true);
        return responsePack;
    }

    @RequestMapping("/filter1/content/like/decrease")
    public ResponsePack<Long> doLikeDecrease(@RequestParam("content_id") Long content_id,HttpServletRequest request) {
        Content content = new Content.Builder()
                .content_id(content_id)
                .build();
        ContentDecorator<Long> contentDecorator = new ContentDecorator<>(contentLikeDecreaseService,false);
        ResponsePack<Long> responsePack = new ResponsePack<>();
        responsePack.setData(contentDecorator.excute(request,new Page(0),content));
        responsePack.setSuccess(true);
        return responsePack;
    }
}
