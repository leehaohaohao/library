package com.lihao.service.serviceImpl.PersonalService;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.dao.ManagerDao;
import com.lihao.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class PersonalManagerUpdateService implements PersonalService<Void> {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Void excute(User user, Manager manager) {
        managerDao.update(manager);
        return null;
    }
}
