package com.lihao.utils;

import com.lihao.bean.Manager;
import com.lihao.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * session内数据取用工具类
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class SessionUtil {
    /**
     * session内账号取出
     * @param request http请求
     * @return account账号
     */
    public static Long getUserId(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Long id;
        User obj = (User)session.getAttribute(ConfigUtil.getPerson());
        id= obj.getUser_id();
        return id;
    }
    public static Long getManagerId(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Long id;
        Manager obj = (Manager)session.getAttribute(ConfigUtil.getManager());
        id = obj.getManager_id();
        return id;
    }
    public static HttpSession getSession(Object obj,HttpServletRequest request,boolean isUser){
        HttpSession session = request.getSession();
        if(isUser){
            session.setAttribute(ConfigUtil.getPerson(),(User)obj);
        }else{
            session.setAttribute(ConfigUtil.getPerson(),(Manager)obj);
        }
        return session;
    }
    public static Object getObj(HttpServletRequest request , boolean isUser){
        HttpSession session = request.getSession();
        if(isUser){
            User user = (User)session.getAttribute(ConfigUtil.getPerson());
            return user;
        }else{
            Manager manager = (Manager)session.getAttribute(ConfigUtil.getManager());
            return manager;
        }
    }
    public static boolean person (HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Object obj = session.getAttribute(ConfigUtil.getPerson());
        if(obj instanceof User){
            return true;
        }else{
            return false;
        }
    }

}
