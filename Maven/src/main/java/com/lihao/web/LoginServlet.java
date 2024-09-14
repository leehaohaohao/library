package com.lihao.web;

import com.lihao.bean.Manager;
import com.lihao.bean.ResponsePack;
import com.lihao.bean.User;
import com.lihao.dao.ManagerDao;
import com.lihao.dao.UserDao;
import com.lihao.exception.Wrong;
import com.lihao.utils.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginServlet {
    @Autowired
    private UserLoginUtil userLoginUtil;
    @Autowired
    private ManagerLoginUtil managerLoginUtil;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ManagerDao managerDao;
    @RequestMapping("/filter1/login")
    public ResponsePack doPost(String user_account_num, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(user_account_num == null || password == null){
            throw new Wrong("输入账号或密码！");
        }
        HttpSession session = request.getSession();
        if(user_account_num.charAt(0)=='t'||user_account_num.charAt(0)=='s'){
            if(userLoginUtil.Userlogin(user_account_num,password)){
                Long user_id = userDao.select_user_id(user_account_num);
                User user = new User.Builder()
                        .user_id(user_id)
                        .build();
                session.setAttribute(ConfigUtil.getPerson(),user);
                CookieUtil.addCookie(response,StringUtil.getToken(),
                        String.valueOf(user_id),60 * 60 * 24 * 10,request.getContextPath());
                ResponsePack responsePack = new ResponsePack();
                responsePack.setData("用户：登陆成功！");
                responsePack.setSuccess(true);
                return responsePack;
            }
            throw new Wrong("登陆失败！");
        }else {
            if(managerLoginUtil.Managerlogin(user_account_num,password)){
                Long manager_id = managerDao.select_manager_id(user_account_num);
                Boolean permissions = managerDao.select_permissions(manager_id);
                Long ok = 0L;
                if(permissions){
                    ok=1L;
                }
                Manager manager = new Manager.Builder()
                        .manager_id(manager_id)
                        .permissions(permissions)
                        .build();
                session.setAttribute(ConfigUtil.getManager(),manager);
                CookieUtil.addCookie(response,StringUtil.getToken(), String.valueOf(manager_id),60 * 60 * 24 * 10,request.getContextPath());
                CookieUtil.addCookie(response,StringUtil.getPermissions(), String.valueOf(ok),60 * 60 * 24 * 10,request.getContextPath());
                ResponsePack responsePack = new ResponsePack();
                responsePack.setData("管理员：登陆成功！");
                responsePack.setSuccess(true);
                return responsePack;
            }
            throw new Wrong("登陆失败！");
        }
    }
}
