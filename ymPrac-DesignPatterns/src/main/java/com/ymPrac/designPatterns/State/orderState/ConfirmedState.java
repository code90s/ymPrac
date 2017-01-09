package com.ymPrac.designPatterns.State.orderState;

/**
 * Created by Yan Meng on 2017/1/6.
 */
class ConfirmedState extends OrderState {
    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("订单已确认，请勿重复确认");
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单已修改，请再次确认");
        orderContext.setState(new OrderedState());
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("订单已支付，无法再修改");
        orderContext.setState(new LockedState());
    }
}