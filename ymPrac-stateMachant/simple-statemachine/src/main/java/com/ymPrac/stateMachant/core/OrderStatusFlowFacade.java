package com.ymPrac.stateMachant.core;


import com.ymPrac.stateMachant.entity.FlowContext;
import com.ymPrac.stateMachant.entity.FlowParam;
import com.ymPrac.stateMachant.entity.OrderStatusEnum;
import com.ymPrac.stateMachant.entity.Transition;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @desc 流程的入口
 *
 * @author flora
 *
 * @date 2016年1月12日 下午4:04:06
 *
 */
@Service
public class OrderStatusFlowFacade {

    @Resource
    protected FlowContext flowContext;
    
    /**
     * 开始流程，明确了起点和终点
     * @author flora
     * @param curStatus
     * @param targetStatus
     * @param flowParam
     */
    public void startFlow(OrderStatusEnum curStatus, OrderStatusEnum targetStatus, FlowParam flowParam) {
        if (flowContext.getTransitions() == null) {
            throw new RuntimeException("系统中未发现任何流程");
        }
        Transition transition = null;
        for (Transition t : flowContext.getTransitions()) {
            if (t.fromStatus() == curStatus && t.toStatus() == targetStatus) {
                transition = t;
                break;
            }
        }
        if (transition == null) {
            throw new RuntimeException("未发现状态" + curStatus + "→" + targetStatus + "的流程");
        }
        transition.execute(flowParam);
    }
    

    /**
     * 开始流程，明确了起点，不知道终点
     * @author flora
     * @param curStatus
     */
    public void startFlow(OrderStatusEnum curStatus, FlowParam flowParam) {
        if (flowContext.getTransitions() == null) {
            throw new RuntimeException("系统中未发现任何流程");
        }
        Transition transition = null;
        for (Transition t : flowContext.getTransitions()) {
            if (t.fromStatus() == curStatus && t.isOk(flowParam)) {
                transition = t;
                break;
            }
        }
        if (transition == null) {
            throw new RuntimeException("未发现状态" + curStatus + "→" + "终点的流程");
        }
        transition.execute(flowParam);
    }
    
    
}
