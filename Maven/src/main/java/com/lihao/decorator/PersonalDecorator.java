package com.lihao.decorator;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import com.lihao.config.SpringConfig;
import com.lihao.dao.FeeDao;
import com.lihao.dao.UserDao;
import com.lihao.exception.Wrong;
import com.lihao.service.PersonalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Transactional
public class PersonalDecorator<T> implements PersonalService<T> {
    private boolean isCheck;
    private PersonalService<T> personalService;
    private ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    public PersonalDecorator(PersonalService<T> personalService , boolean isCheck){
        this.isCheck=isCheck;
        this.personalService=personalService;
    }
    @Override
    public T excute(User user, Manager manager) throws Wrong {
        if(isCheck){
        }
        FeeDao feeDao = context.getBean(FeeDao.class);
        UserDao userDao = context.getBean(UserDao.class);
        BigDecimal[] fees = feeDao.select_fee_num(user.getUser_id());
        BigDecimal money = BigDecimal.ZERO;
        for(BigDecimal f:fees){
            money = money.add(f);
        }
        if(userDao.update_user_fee_all(user.getUser_id(),money)!=1){
            throw new Wrong("系统错误！");
        }
        return personalService.excute(user,manager);
    }
}
