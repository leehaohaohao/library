package com.lihao.filter;

import com.lihao.bean.User;
import com.lihao.utils.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截请求
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
@Component
public class Filter1 implements HandlerInterceptor {

    /**
     * 拦截请求，判断是否登录过
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession(false);
        String path = request.getServletPath();
        if(path.equals(ConfigUtil.getWelcome())
                || path.equals(ConfigUtil.getLogin())
                || path.equals(ConfigUtil.getLoginUrl())){
            return true;
        }
        if(session!=null){
            if(session.getAttribute(ConfigUtil.getPerson())!=null){
                return true;
            }
        }
        if(CookieUtil.getCookie(request, StringUtil.getToken())!=null){
            String token= CookieUtil.getCookie(request, StringUtil.getToken());
            Long user_id =Long.valueOf(token);
            User user = new User.Builder()
                    .user_id(user_id)
                    .build();
            session = SessionUtil.getSession(user,request,true);
            return true;
        }
        CookieUtil.removeCookie(response,StringUtil.getToken(),request.getContextPath());
        response.getWriter().write("您还没有登陆！");
        return false;
    }
}
