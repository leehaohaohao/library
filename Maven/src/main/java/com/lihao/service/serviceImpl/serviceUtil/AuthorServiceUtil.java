package com.lihao.service.serviceImpl.serviceUtil;

import com.lihao.bean.Author;
import com.lihao.dao.AuthorDao;
import com.lihao.exception.Wrong;
import com.lihao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthorServiceUtil {
    @Autowired
    private AuthorDao authorDao;
    public Author authorHandle(String name) throws Wrong {
        Author author = authorDao.select_author(name);
        if(author==null){
            if(authorDao.insert_author(name)==1){
                author = authorDao.select_author(name);
            }else{
                throw new Wrong(StringUtil.getInsert_fail());
            }
        }
        return author;
    }

}
