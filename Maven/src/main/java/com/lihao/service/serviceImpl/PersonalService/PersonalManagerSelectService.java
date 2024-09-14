package com.lihao.service.serviceImpl.PersonalService;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.dao.ManagerDao;
import com.lihao.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalManagerSelectService implements PersonalService<Manager> {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Manager excute(User user, Manager manager) {
        return managerDao.select_by_id(manager.getManager_id());
    }
}
