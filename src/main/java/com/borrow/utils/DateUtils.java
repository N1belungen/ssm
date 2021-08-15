package com.borrow.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {	// 防止被其他类继承

    private DateUtils() {	// 防止被实例化
        super();
    }

    // 获取借阅书籍的时间
    public static String getBorrowDate(){
        Date date =new Date();
        SimpleDateFormat returnDate = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = returnDate.format(date);
        return borrowTime;
    }

    //计算还书时间
    public static String getReturnDate(int dayMount) {
        Date date =new Date();
        SimpleDateFormat returnDate = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DATE , calendar.get(Calendar.DATE) + dayMount);
        Date time = calendar.getTime();
        String returnTime = returnDate.format(time);

        return returnTime;
    }

}
