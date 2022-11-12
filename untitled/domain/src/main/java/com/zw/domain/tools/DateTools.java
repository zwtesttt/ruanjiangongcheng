package com.zw.domain.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
    public static String getDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String re=dateFormat.format(date);
        return re;
    }
}
