package com.lihao.utils;

import java.util.ResourceBundle;

/**
 * 一些参数配置获取工具类
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class ConfigUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("servlet");
    public static String getPassword(){
        return bundle.getString("password");
    }
    public static String getLoginUrl(){
        return bundle.getString("login_url");
    }
    public static String getHome(){
        return bundle.getString("home");
    }
    public static String getLogin(){
        return bundle.getString("login");
    }
    public static String getWelcome(){
        return bundle.getString("welcome");
    }
    public static String getPerson(){
        return bundle.getString("person");
    }
    public static String getManager(){
        return bundle.getString("manager");
    }
    public static String getManager_home(){
        return bundle.getString("manager_home");
    }
}
