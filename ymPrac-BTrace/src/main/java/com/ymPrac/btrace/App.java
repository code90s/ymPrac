package com.ymPrac.btrace;

/**
 * 倍btrace 监控的app
 * Created by Yan Meng on 2017/12/13.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        int[] a = new int[]{
                20,
                21,
                21,
                21,
                22,
                19,
                24,
                27,
                20,
                34,
                23,
                20,
                17,
                21,
                20,
                18,
                19,
                20,
                24,
                20,
                23,
                22,
                27
        };

        //int s=0;
        BtraceTest bt = new BtraceTest();
        while (true) {
            for (int i : a) {
                bt.getret(i);
                Thread.sleep(100);
            }

            Thread.sleep(500);
        }
    }
}
