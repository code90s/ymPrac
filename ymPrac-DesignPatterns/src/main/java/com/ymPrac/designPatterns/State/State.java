package com.ymPrac.designPatterns.State;

import java.awt.*;

/**
 * 抽象状态 接口
 * Created by Yan Meng on 2017/1/9.
 */
public interface State {

    public abstract void handlepush(Context c);
    public abstract void handlepull(Context c);
    public abstract Color getcolor();
}
