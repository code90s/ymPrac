package com.ymPrac.drools;

/**
 * 规则接口
 *
 * @author quzishen
 */
public interface PointRuleEngine {

    /**
     * 初始化规则引擎
     */
    void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    void refreshEnginRule();

    /**
     * 执行规则引擎
     *
     * @param pointDomain 积分Fact
     */
    void executeRuleEngine(final PointDomain pointDomain);
}
