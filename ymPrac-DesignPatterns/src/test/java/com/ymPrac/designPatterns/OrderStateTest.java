package com.ymPrac.designPatterns;

import com.ymPrac.designPatterns.State.orderState.OrderContext;

import org.junit.Test;

/**
 * Created by Yan Meng on 2017/1/6.
 */
public class OrderStateTest {

    @Test
    public void testOrderState() {
        OrderContext orderContext = new OrderContext();
        orderContext.confirm();                         // 已预定状态>已确认状态
        orderContext.modify();                          // 已确认状态>已预定状态
        orderContext.confirm();                         // 已预定状态>已确认状态
        orderContext.pay();                             // 已确认状态>已锁定状态
        orderContext.modify();                          // 已锁定状态
    }
}
