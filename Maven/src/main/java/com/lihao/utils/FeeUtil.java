package com.lihao.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 计算相关订单费用
 * @author lihao
 * @version 1.0
 * @since 1.0
 */
public class FeeUtil {
    /**
     * 计算费用
     * @param borrow_final_date 理应归还日期
     * @return 费用
     */
    public static BigDecimal getFee(Date borrow_final_date){
        Date nowDate = new Date();
        long diffInMillies = Math.abs(borrow_final_date.getTime() - nowDate.getTime());
        long diffInHours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return BigDecimal.valueOf(diffInHours*LongUtil.getMoney());
    }
}
