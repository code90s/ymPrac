package com.ymPrac.jvm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 约瑟夫环的java实现
 * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。从编号为k的人开始报数，
 * 数到m的那个人出列;他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
 * Created by Yan Meng on 2017/10/13.
 */
public class Josephus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入总人数：");
        int totalNum = scanner.nextInt();
        System.out.print("请输入报数的大小：");
        int cycleNum = scanner.nextInt();
        yuesefu(totalNum, cycleNum);
    }

    private static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
