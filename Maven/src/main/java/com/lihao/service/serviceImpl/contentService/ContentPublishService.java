package com.lihao.service.serviceImpl.contentService;

import com.lihao.bean.Content;
import com.lihao.bean.Page;
import com.lihao.bean.User;
import com.lihao.bean.UserCategory;
import com.lihao.dao.ContentDao;
import com.lihao.dao.UserCategoryDao;
import com.lihao.dao.UserDao;
import com.lihao.service.ContentService;
import com.lihao.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
@Transactional
@Service
public class ContentPublishService implements ContentService<Integer> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private UserCategoryDao userCategoryDao;

    @Override
    public Integer excute(HttpServletRequest request, Page page, Content con) {
        Long user_id = SessionUtil.getUserId(request);
        User user = userDao.select_by_id(user_id);
        if(userDao.blacklist(user_id).equals("0")){
            UserCategory userCategory = userCategoryDao.select(user.getUser_category_id());
            Content content = new Content.Builder()
                    .publish_date(con.getPublish_date())
                    .content(con.getContent())
                    .userCategory(userCategory)
                    .user(user)
                    .like_num(0L)
                    .build();
            if(contentDao.insert(content)==1){
                return 1;
            }
        }
        return 0;
    }
}
