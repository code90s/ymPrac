package com.ymPrac.jvm;

import org.joda.time.DateTime;

/**
 * Created by Yan Meng on 2017/11/13.
 */
public class DateTest {

    public static void main(String[] args) {
        DateTime dt = new DateTime();
        System.out.println(dt);
        DateTime dateTime = dt.plusMinutes(1);
        System.out.println(dt);
        System.out.println(dateTime);


//        System.out.println(dt.getDayOfMonth());
//        System.out.println(dt.getHourOfDay());
//        System.out.println(dt.getMinuteOfHour());
//        System.out.println(dt.getSecondOfMinute());
    }
}
