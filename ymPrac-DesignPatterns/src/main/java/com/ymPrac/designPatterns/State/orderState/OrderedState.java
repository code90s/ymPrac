package com.ymPrac.designPatterns.State.orderState;

/**
 * Created by Yan Meng on 2017/1/6.
 */
class OrderedState extends OrderState {
    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("订单已确认");
        orderContext.setState(new ConfirmedState());
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单已修改");
        orderContext.setState(this);
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("预定状态无法完成订单！");
    }
}