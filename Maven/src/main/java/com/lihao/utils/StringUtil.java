package com.lihao.utils;

import java.util.ResourceBundle;

public class StringUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("string");
    public static String getNot_enough(){
        return bundle.getString("not_enough");
    }
    public static String getBorrow_system_error(){
        return bundle.getString("borrow_system_error");
    }
    public static String getNot_book(){
        return bundle.getString("not_book");
    }
    public static String getBorrow_success(){
        return bundle.getString("borrow_success");
    }
    public static String getBorrow_fail(){
        return bundle.getString("borrow_fail");
    }
    public static String getNull(){
        return bundle.getString("null");
    }
    public static String getBorrowing(){
        return bundle.getString("borrowing");
    }
    public static String getOverrun(){
        return bundle.getString("overrun");
    }
    public static String getLost(){
        return bundle.getString("lost");
    }
    public static String getReturning(){
        return bundle.getString("returning");
    }
    public static String getContent_publish_success(){return bundle.getString("content_publish_success");}
    public static String getContent_publish_fail(){return bundle.getString("content_publish_fail");}
    public static String getContent_system_error(){
        return bundle.getString("content_system_error");
    }
    public static String getBook_return_success(){
        return bundle.getString("book_return_success");
    }
    public static String getBook_return_fail(){
        return bundle.getString("book_return_fail");
    }
    public static String getBook_renew_success(){
        return bundle.getString("book_renew_success");
    }
    public static String getBook_renew_fail(){
        return bundle.getString("book_renew_fail");
    }
    public static String getToken(){
        return bundle.getString("token");
    }
    public static String getFail(){
        return bundle.getString("fail");
    }
    public static String getBook_lost_success(){
        return bundle.getString("book_lost_success");
    }
    public static String getBook_lost_fail(){
        return bundle.getString("book_lost_fail");
    }
    public static String getFee_pay_success(){
        return bundle.getString("fee_pay_success");
    }
    public static String getFee_pay_fail(){
        return bundle.getString("fee_pay_fail");
    }
    public static String getInsert_success(){
        return bundle.getString("insert_success");
    }
    public static String getInsert_fail(){
        return bundle.getString("insert_fail");
    }
    public static String getRoot(){
        return bundle.getString("root");
    }
    public static String getBook_root(){
        return bundle.getString("book_root");
    }
    public static String getPermissions(){
        return bundle.getString("permissions");
    }
    public static String getDelete_success(){
        return bundle.getString("delete_success");
    }
    public static String getDelete_fail(){
        return bundle.getString("delete_fail");
    }
    public static String getUpdate_success(){
        return bundle.getString("update_success");
    }
    public static String getUpdate_fail(){
        return bundle.getString("update_fail");
    }
    public static String getStudent_root(){
        return bundle.getString("student_root");
    }
    public static String getTeacher_root(){
        return bundle.getString("teacher_root");
    }
    public static String getBlacklist_fail(){
        return bundle.getString("blacklist_fail");
    }
    public static String getBlacklist_success(){
        return bundle.getString("blacklist_success");
    }
    public static String getManager_root(){
        return bundle.getString("manager_root");
    }
    public static String getUri(){
        return bundle.getString("uri");
    }
}
