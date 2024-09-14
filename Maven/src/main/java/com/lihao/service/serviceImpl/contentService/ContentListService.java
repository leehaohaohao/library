package com.lihao.service.serviceImpl.contentService;

import com.github.pagehelper.PageHelper;
import com.lihao.bean.Content;
import com.lihao.bean.Page;
import com.lihao.dao.ContentDao;
import com.lihao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class ContentListService implements ContentService<List<Content>> {
    @Autowired
    private ContentDao contentDao;
    @Override
    public List<Content> excute(HttpServletRequest request, Page page, Content content) {
        PageHelper.startPage(page.getPage_num(), page.getPage_size());
        return contentDao.select_all();
    }
}
