package com.ymPrac.designPatterns.State;

import java.awt.*;

/**
 * Created by Yan Meng on 2017/1/9.
 */
public class BlueState implements State {
    @Override
    public void handlepush(Context c) {
        //根据push方法"如果是blue状态的切换到green" ;
        c.setState(new GreenState());
    }

    @Override
    public void handlepull(Context c) {
        //根据pull方法"如果是blue状态的切换到red" ;
        c.setState(new RedState());
    }

    @Override
    public Color getcolor() {
        return (Color.BLUE);
    }
}
