package com.lihao.filter;

import com.lihao.bean.Manager;
import com.lihao.dao.ManagerDao;
import com.lihao.utils.CookieUtil;
import com.lihao.utils.SessionUtil;
import com.lihao.utils.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ManagerCheck implements HandlerInterceptor {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long manager_id;
        Boolean permissions;
        Manager manager = (Manager) SessionUtil.getObj(request,false);
        if(manager==null){
            manager_id = getManagerIdFromCookie(request);
            permissions = getPermissionsFromCookie(request);
        }else{
            manager_id = manager.getManager_id();
            permissions = manager.getPermissions();
        }
        //验证当前用户是否有管理员权限
        if(checkPermissions(permissions, manager_id)){
            return true;
        }else{
            manager_id = getManagerIdFromCookie(request);
            permissions = getPermissionsFromCookie(request);
            if(checkPermissions(permissions, manager_id)){
                return true;
            }
            CookieUtil.removeCookie(response, StringUtil.getToken(),request.getContextPath());
            CookieUtil.removeCookie(response, StringUtil.getPermissions(),request.getContextPath());
            response.getWriter().write("您没有权限调用！");
            return false;
        }
    }

    private boolean checkPermissions(Boolean permissions, Long manager_id) {
        return permissions && manager_id != null && managerDao.select_by_id(manager_id) != null;
    }

    private Long getManagerIdFromCookie(HttpServletRequest request) {
        String managerIdStr = CookieUtil.getCookie(request,StringUtil.getToken());
        return managerIdStr != null ? Long.parseLong(managerIdStr) : null;
    }

    private Boolean getPermissionsFromCookie(HttpServletRequest request) {
        String permissionsStr = CookieUtil.getCookie(request, StringUtil.getPermissions());
        return permissionsStr != null && Long.parseLong(permissionsStr) == 1L;
    }
}
