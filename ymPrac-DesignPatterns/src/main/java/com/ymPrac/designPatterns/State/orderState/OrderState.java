package com.ymPrac.designPatterns.State.orderState;

/**
 * Created by Yan Meng on 2017/1/6.
 */
public abstract class OrderState {

    abstract void confirm(OrderContext orderContext);

    abstract void modify(OrderContext orderContext);

    abstract void pay(OrderContext orderContext);
}
