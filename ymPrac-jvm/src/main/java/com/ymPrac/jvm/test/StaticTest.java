package com.ymPrac.jvm.test;

/**
 * static 与巨款 测试
 * Created by Yan Meng on 2017/7/10.
 */
public class StaticTest {
    static {
        System.out.println("main");
    }

    public static void main(String[] args) {
        System.out.println("start ----------------");
        Demo demo = new Demo();

        System.out.println("end--------------------");
    }

}


class Demo {
    static {
        System.out.println("demo ___________________");
    }
}