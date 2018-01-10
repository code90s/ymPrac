package com.ymPrac.jvm;

import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;

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

        Set set1 = new HashSet();
        set1.add("a");
        set1.add("b");
        set1.add("d");
        Set set2 = new HashSet();
        set2.add("a");
        set2.add("b");
        set2.add("c");

        Set sn = new HashSet(set1);
        System.out.println(sn.retainAll(set2));  //求交集
        System.out.println(sn);

        Set su = new HashSet(set1);
        System.out.println(su.addAll(set2));
        System.out.println(su);//求并集

        Set se = new HashSet();
        se.add("z");
        System.out.println(se.retainAll(set1));
        System.out.println(se);

//        System.out.println(dt.getDayOfMonth());
//        System.out.println(dt.getHourOfDay());
//        System.out.println(dt.getMinuteOfHour());
//        System.out.println(dt.getSecondOfMinute());
    }
}
