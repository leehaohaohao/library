package com.lihao.utils;


import com.lihao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

/**
 * 登录工具类
 * @author lihao
 * @version 2.0（对比1.0更新了mybatis框架）
 * @since 1.0
 */
@Component
public class UserLoginUtil {
    /**
     * 登陆工具类（验证登陆）
     * @param account 账号
     * @param password 密码
     * @return true登录成功 false登录失败
     * @throws SQLException
     */
    @Autowired
    private UserDao userDaoImpl;
    public boolean Userlogin(String account,String password) throws SQLException {
        if(userDaoImpl.login_confirm(account).equals(password)){
            return true;
        }
        return false;
    }
}
