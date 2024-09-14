package com.lihao.service.serviceImpl.PersonalService;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.dao.UserDao;
import com.lihao.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalUserSelectService implements PersonalService<User> {
    @Autowired
    private UserDao userDao;
    @Override
    public User excute(User user, Manager manager) {
        return userDao.select_by_id(user.getUser_id());
    }
}
