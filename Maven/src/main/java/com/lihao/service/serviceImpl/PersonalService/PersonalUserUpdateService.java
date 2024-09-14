package com.lihao.service.serviceImpl.PersonalService;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.dao.UserDao;
import com.lihao.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class PersonalUserUpdateService implements PersonalService<Void> {
    @Autowired
    private UserDao userDao;
    @Override
    public Void excute(User user, Manager manager) {
        userDao.update(user);
        return null;
    }
}
