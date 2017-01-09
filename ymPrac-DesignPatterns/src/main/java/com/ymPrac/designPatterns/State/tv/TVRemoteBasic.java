package com.ymPrac.designPatterns.State.tv;

/**
 * 不使用状态模式 原始方式
 * 注意：客户端代码需要知道每一个不同的值所代表的遥控器的不同状态。如果这样，假如大量的状态被增加，
 *       那么对于被紧紧捆绑在一起的状态实现以及相应的客户端代码，它们的维护及扩展就变得非常困难。
 * Created by Yan Meng on 2017/1/10.
 */
public class TVRemoteBasic {
    private String state = "";

    public void setState(String state) {
        this.state = state;
    }

    public void doAction() {
        if (state.equalsIgnoreCase("ON")) {
            System.out.println("TV is turned ON");
        } else if (state.equalsIgnoreCase("OFF")) {
            System.out.println("TV is turned OFF");
        }
    }

    public static void main(String args[]) {
        TVRemoteBasic remote = new TVRemoteBasic();

        remote.setState("ON");
        remote.doAction();

        remote.setState("OFF");
        remote.doAction();
    }

}
