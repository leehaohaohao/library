package com.lihao.web;

import com.lihao.bean.User;
import com.lihao.utils.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class WelcomeServlet {

    @RequestMapping("/welcome")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token= CookieUtil.getCookie(request, StringUtil.getToken());
        if(token!=null){
            Long user_id =Long.valueOf(token);
            User user = new User.Builder()
                    .user_id(user_id)
                    .build();
            HttpSession session = SessionUtil.getSession(user,request,true);
            response.sendRedirect(request.getContextPath()+ConfigUtil.getHome());
            return;
        }
        response.sendRedirect(request.getContextPath()+ConfigUtil.getLogin());
    }
}
