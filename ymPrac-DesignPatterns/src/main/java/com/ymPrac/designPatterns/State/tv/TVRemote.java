package com.ymPrac.designPatterns.State.tv;

/**
 * 使用状态设计模式的优势就是实现多态性的过程是清晰可见的。状态的改变中产生的错误也较少，
 * 另外增加更多的状态以及行为变得容易且更具鲁棒性。此外状态模式也帮助避免if-else子句或者switch-case条件判定逻辑。
 * Created by Yan Meng on 2017/1/10.
 */
public class TVRemote {

    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();

        context.setState(tvStopState);
        context.doAction();
    }

}
