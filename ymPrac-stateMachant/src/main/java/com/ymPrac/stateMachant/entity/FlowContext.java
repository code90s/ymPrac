package com.ymPrac.stateMachant.entity;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc 流程的上下文信息
 *
 * @author flora
 *
 * @date 2016年1月12日 下午4:03:40
 *
 */
@Service
public class FlowContext {

    private Set<Transition> transitions = new HashSet<Transition>();
    
    /**
     * 注册新流程
     * @author flora
     */
    public void registerTransition(Transition transition) {
        transitions.add(transition);
    }

    public Set<Transition> getTransitions() {
        return transitions;
    }
    
}
