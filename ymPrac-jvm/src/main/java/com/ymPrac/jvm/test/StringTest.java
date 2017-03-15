package com.ymPrac.jvm.test;

import java.util.Arrays;

/**
 * Created by Yan Meng on 2017/3/15.
 */
public class StringTest {

    public static void main(String[] args) {
        String s = "aaa";

        String[] idsArray = s.split(";");

        System.out.println(Arrays.toString(idsArray));
    }
}
