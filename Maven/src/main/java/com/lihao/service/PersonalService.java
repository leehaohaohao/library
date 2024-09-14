package com.lihao.service;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.exception.Wrong;

public interface PersonalService<T>{
    T excute(User user, Manager manager) throws Wrong;
}
