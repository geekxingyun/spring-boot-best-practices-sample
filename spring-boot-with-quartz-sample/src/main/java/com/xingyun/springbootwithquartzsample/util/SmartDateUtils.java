package com.xingyun.springbootwithquartzsample.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qing-feng.zhao
 * @功能
 */
public final class SmartDateUtils {

    /**
     * 将字符串转换成日期类型
     * @param strDate
     * @return
     */
    public static synchronized Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date stringToDate = formatter.parse(strDate, pos);
        return stringToDate;
    }
}
