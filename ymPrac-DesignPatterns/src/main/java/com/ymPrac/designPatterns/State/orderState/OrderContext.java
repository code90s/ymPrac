package com.ymPrac.designPatterns.State.orderState;

/**
 * Created by Yan Meng on 2017/1/6.
 */
public class OrderContext {
    OrderState state = null;
    // 新建订单设为已预定状态
    public OrderContext() {
        this.state = new OrderedState();
    }

    void setState(OrderState state) {
        this.state = state;
    }

    public void confirm() {
        state.confirm(this);
    }

    public void modify() {
        state.modify(this);
    }

    public void pay() {
        state.pay(this);
    }
}
