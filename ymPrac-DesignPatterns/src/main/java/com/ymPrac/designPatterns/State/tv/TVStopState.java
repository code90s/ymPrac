package com.ymPrac.designPatterns.State.tv;

/**
 * Created by Yan Meng on 2017/1/10.
 */
public class TVStopState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}
