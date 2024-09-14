package com.lihao.web.person;

import com.lihao.bean.Manager;
import com.lihao.bean.ResponsePack;
import com.lihao.bean.User;
import com.lihao.bean.userDTO.UserBaseInfoDto;
import com.lihao.dao.UserDao;
import com.lihao.decorator.PersonalDecorator;
import com.lihao.exception.Wrong;
import com.lihao.service.PersonalService;
import com.lihao.utils.*;
import com.lihao.web.BaseServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/filter1")
public class PersonServlet extends BaseServlet {
    @Autowired
    private PersonalService<User> personalUserSelectService;

    @Autowired
    private PersonalService<Void> personalUserUpdateService;

    @Autowired
    private PersonalService<Manager> personalManagerSelectService;

    @Autowired
    private PersonalService<Void> personalManagerUpdateService;
    @Autowired
    private UserDao userDao;
    @RequestMapping("/person/select")
    public ResponsePack<User> doPerson_user_select(HttpServletRequest request) throws Wrong {
        Long user_id = SessionUtil.getUserId(request);
        User use = new User.Builder()
                .user_id(user_id)
                .build();
        PersonalDecorator<User> personalDecorator = new PersonalDecorator<>(personalUserSelectService,false);
        return getSuccessResponsePack(personalDecorator.excute(use,new Manager()));
    }

    @RequestMapping("/person/update")
    public ResponsePack doPerson_user_update(String email, String gender,
                                             String name,String telephone_num,
                                             HttpServletRequest request) throws Wrong {
        Long user_id = SessionUtil.getUserId(request);
        if(!gender.equals("男")&&!gender.equals("女")){
            throw new Wrong("无效参数！");
        }
        User user = new User.Builder()
                .user_id(user_id)
                .email(email)
                .gender(gender)
                .name(name)
                .telephone_num(telephone_num)
                .build();
        PersonalDecorator<Void> personalDecorator = new PersonalDecorator<>(personalUserUpdateService,false);
        personalDecorator.excute(user,new Manager());
        return getSuccessResponsePack("更新成功！");
    }

    @RequestMapping("/manager/select")
    public ResponsePack<Manager> doPerson_manager_select(HttpServletRequest request) throws Wrong {
        Long manager_id = SessionUtil.getManagerId(request);
        Manager man = new Manager.Builder()
                .manager_id(manager_id)
                .build();
        PersonalDecorator<Manager> personalDecorator = new PersonalDecorator<>(personalManagerSelectService,false);
        return getSuccessResponsePack(personalDecorator.excute(null,man));
    }

    @RequestMapping("/manager/update")
    public ResponsePack doPerson_manager_update(HttpServletRequest request) throws Wrong {
        Long manager_id = SessionUtil.getManagerId(request);
        Manager manager = new Manager.Builder()
                .manager_id(manager_id)
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .gender(request.getParameter("gender"))
                .name(request.getParameter("name"))
                .telephone_num(request.getParameter("telephone_num"))
                .build();
        PersonalDecorator<Void> personalDecorator = new PersonalDecorator<>(personalManagerUpdateService,false);
        personalDecorator.excute(new User(),manager);
        return getSuccessResponsePack("更新成功！");
    }
    @RequestMapping("/person/baseInfo")
    public ResponsePack<UserBaseInfoDto> baseInfo(HttpServletRequest request){
        Long user_id = SessionUtil.getUserId(request);
        return getSuccessResponsePack(userDao.userBaseInfo(user_id));
    }
}
