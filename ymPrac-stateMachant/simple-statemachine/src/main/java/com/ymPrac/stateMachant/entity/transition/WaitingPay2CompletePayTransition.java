package com.ymPrac.stateMachant.entity.transition;


import com.ymPrac.stateMachant.entity.FlowParam;
import com.ymPrac.stateMachant.entity.OrderStatusEnum;
import com.ymPrac.stateMachant.entity.Transition;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @desc 待支付到支付完成
 *
 * @author flora
 *
 * @date 2016年1月12日 下午4:18:53
 *
 */
@Service
public class WaitingPay2CompletePayTransition extends Transition implements InitializingBean {

    @Override
    public OrderStatusEnum fromStatus() {
        return OrderStatusEnum.WaitingPay;
    }

    @Override
    public OrderStatusEnum toStatus() {
        return OrderStatusEnum.CompletedPay;
    }

    @Override
    public void execute(FlowParam flowParam) {
        System.out.println("正在执行" + fromStatus() + "→" + toStatus() + "的流程.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        flowContext.registerTransition(this);
    }

    
}
