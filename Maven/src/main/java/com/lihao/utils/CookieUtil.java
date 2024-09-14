package com.lihao.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class CookieUtil {
    /**
     * 创建cookie
     * @param response
     * @param name cookie名字
     * @param value cookie值
     * @param maxAge cookie最大寿命
     * @param path cookie存放路径
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String path) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 移除cookie
     * @param response
     * @param name
     * @param path
     */
    public static void removeCookie(HttpServletResponse response, String name, String path) {
        addCookie(response, name, null, 0, path);
    }
}
