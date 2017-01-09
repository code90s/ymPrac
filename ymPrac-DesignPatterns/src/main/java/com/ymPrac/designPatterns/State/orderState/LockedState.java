package com.ymPrac.designPatterns.State.orderState;

/**
 * Created by Yan Meng on 2017/1/6.
 */
class LockedState extends OrderState {
    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }
}