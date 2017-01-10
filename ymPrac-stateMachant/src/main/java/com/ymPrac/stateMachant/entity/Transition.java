package com.ymPrac.stateMachant.entity;

import javax.annotation.Resource;

/**
 * @desc 定义流程通用对象
 *
 * @author flora
 *
 * @date 2016年1月12日 下午4:17:44
 *
 */
public class Transition {
    
    @Resource
    protected FlowContext flowContext;
    
    /**
     * 起始节点
     * @author flora
     * @return
     */
    public OrderStatusEnum fromStatus() {
        throw new RuntimeException("未指定起始节点");
    };
    
    /**
     * 结束节点
     * @author flora
     * @return
     */
    public OrderStatusEnum toStatus() {
        throw new RuntimeException("未指定终止节点");
    };
    
    /**
     * 执行该流程
     * @author flora
     * @param context
     */
    public void execute(FlowParam flowParam) {
        // 不做任何操作
    }
    
    /**
     * 是否符合进入流程的条件
     * @author flora
     * @param flowParam
     * @return
     */
    public boolean isOk(FlowParam flowParam) {
        return false;
    }
    
}
