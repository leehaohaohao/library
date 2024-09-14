package com.lihao.service.serviceImpl.contentService;

import com.lihao.bean.Content;
import com.lihao.bean.Page;
import com.lihao.dao.ContentDao;
import com.lihao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
@Transactional
@Service
public class ContentLikeIncreaseService implements ContentService<Long> {
    @Autowired
    private ContentDao contentDao;
    @Override
    public Long excute(HttpServletRequest request, Page page, Content con) {
        Long like_num = contentDao.select_like(con.getContent_id());
        Content content = new Content.Builder()
                .content_id(con.getContent_id())
                .like_num(like_num+1L)
                .build();
        if(contentDao.update_like(content)==1){
            return content.getLike_num();
        }
        return null;
    }
}
