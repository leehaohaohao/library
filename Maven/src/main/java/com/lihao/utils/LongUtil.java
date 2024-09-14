package com.lihao.utils;

import java.util.ResourceBundle;

public class LongUtil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("long");
    public static Long getNull(){
        return Long.parseLong(bundle.getString("null"));
    }
    public static Long getBorrowing(){
        return Long.parseLong(bundle.getString("borrowing"));
    }
    public static Long getOverrun(){
        return Long.parseLong(bundle.getString("overrun"));
    }
    public static Long getLost(){
        return Long.parseLong(bundle.getString("lost"));
    }
    public static Long getReturning(){
        return Long.parseLong(bundle.getString("returning"));
    }
    public static Long getMoney(){
        return Long.parseLong(bundle.getString("money"));
    }
    public static Long getFee_overrun(){
        return Long.parseLong(bundle.getString("fee_overrun"));
    }
    public static Long getFee_lost(){
        return Long.parseLong(bundle.getString("fee_lost"));
    }
    public static Long getFee_incomplete(){
        return Long.parseLong(bundle.getString("fee_incomplete"));
    }
    public static Long getFee_paid(){
        return Long.parseLong(bundle.getString("fee_paid"));
    }
    public static Long getFee_unpaid(){
        return Long.parseLong(bundle.getString("fee_unpaid"));
    }
    public static Long getProcess(){
        return Long.parseLong(bundle.getString("process"));
    }
    public static Long getReturn_incomplete(){
        return  Long.parseLong(bundle.getString("return_incomplete"));
    }
    public static Long getReturn_complete(){
        return  Long.parseLong(bundle.getString("return_complete"));
    }
    public static int getRenew_date(){
        return Integer.parseInt(bundle.getString("renew_date"));
    }
    public static int getBorrow_date(){
        return Integer.parseInt(bundle.getString("borrow_date"));
    }
}
