package com.ymPrac.stateMachant;

import com.ymPrac.stateMachant.core.OrderStatusFlowFacade;
import com.ymPrac.stateMachant.entity.FlowParam;
import com.ymPrac.stateMachant.entity.OrderStatusEnum;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * @desc 单元测试
 *
 * @author flora
 *
 * @date 2016年1月12日 下午5:35:48
 *
 */
public class FlowTest extends BaseTest {

	@Resource
	private OrderStatusFlowFacade orderStatusFlowFacade;

	@Test
	public void test() throws Exception {
	    FlowParam flowParam = new FlowParam();
	    try {
	        orderStatusFlowFacade.startFlow(OrderStatusEnum.WaitingPay, OrderStatusEnum.CompletedPay, flowParam);
	        orderStatusFlowFacade.startFlow(OrderStatusEnum.WaitingPay, OrderStatusEnum.WaitingPickUp, flowParam);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}
