package com.ymPrac.designPatterns.State.tv;

/**
 * Created by Yan Meng on 2017/1/10.
 */
public class TVContext implements State {

    private State tvState;

    public void setState(State state) {
        this.tvState=state;
    }

    public State getState() {
        return this.tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}
