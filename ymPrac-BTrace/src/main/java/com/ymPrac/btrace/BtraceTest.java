package com.ymPrac.btrace;

/**
 * Created by Yan Meng on 2017/12/13.
 */
public class BtraceTest {

    private long ret = 0;

    public long getret(int num) {
        ret += num;
        method1();
        method2();
        method3();
        return ret;
    }

    private void method1() {
        String a = "asdfadsfa" + "sdfasdfdsf";
    }

    private void method2() {
        double a = 1000 / 3.14;
    }

    private void method3() {
        float a = (float) (1000 / 3.14);
    }

}
