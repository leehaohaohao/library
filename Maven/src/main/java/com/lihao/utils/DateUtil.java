package com.lihao.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 更新借阅终止时间
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class DateUtil {
    /**
     *
     * @param borrow_final_date 理应归还日期
     * @param days 续借天数
     * @return 续借截止日期
     */
    public static Date getDate(Date borrow_final_date,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrow_final_date);
        calendar.add(Calendar.DATE,days);
        return calendar.getTime();
    }
}
