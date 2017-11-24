package com.ymPrac.stateMachant.entity;

/**
 * 
 * @author wr
 *
 */
public enum OrderStatusEnum {

	WaitingPay(1, "待支付", 0x1), // 1-1

	CompletedPay(1 << 1, "完成支付", 0x2), // 2-2

	WaitingProduction(1 << 2, "等待生产", 0x4), // 4-4

	Pause(1 << 2, "暂停", 0x3), // 4-3

	// COOCreate(1 << 2, "COO等待生产", 0x3), // 4-3

	// OrderPurchase(1<<2, "下发OFC", 0x4), // 4-4

	Producting(1 << 3, "生产中", 0x8), // 8-8

	/*
	 * 自提订单：自提订单，完成打包，但未操作妥投或者拒收; 配送订单：订单打包完成或者再投已入站或者已撤销分配，但未分配配送员
	 */
	WaitingPickUp(1 << 4, "等待自提/等待配送", 0x10), // 16-16

	WaitingReceipt(1 << 5, "配送中", 0x20), // 32-32

	OrderCompleted(1 << 6, "订单妥投", 0x40), // 64-64

	OrderFinished(1 << 10, "订单完成", 0x400), // 1024-1024 ,订单完成（妥投+对账完成）

	Canceled(1 << 7, "用户取消", 0x80), // 128-128 //生产系统不存在,只为历史数据保留
	SysCanceled(1 << 7, "系统取消", 0x81), // 128-129 //生产系统已停用,只为历史数据保留
	OpCanceled(1 << 7, "运维取消", 0x82), // 128-130 //生产系统已停用,只为历史数据保留
	OpCanceledByStock(1 << 7, "系统取消(缺货)", 0x83), // 128-131 //生产系统已停用,只为历史数据保留
	OpReCreateCancled(1 << 7, "系统取消(修改订单)", 0x84), // 128-132 //生产系统已停用,只为历史数据保留
	RefuseProcessed(128, "拒收已入站", 0x85), // 133
	RefuseStockReturn(128, "拒收已退库", 0x86), // 134
	OrderCanceled(128, "取消订单", 0x87), // 135

	/** 目前仅适用于线下推送订单 */
	WaitUserConfirm(1 << 8, "待用户确认", 0x100), // 256-256

	UserConfirmed(1 << 9, "用户已确认", 0x200);// 512-512

	private int key;
	private String value;
	private int code;

	OrderStatusEnum(int key, String value, int code) {
		this.key = key;
		this.value = value;
		this.code = code;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static String getValueByKey(int key) {
		for (OrderStatusEnum enums : OrderStatusEnum.values()) {
			if (enums.getKey() == key) {
				return enums.getValue();
			}
		}
		return null;
	}

	public static String getValueByCode(int code) {
		for (OrderStatusEnum enums : OrderStatusEnum.values()) {
			if (enums.getCode() == code) {
				return enums.getValue();
			}
		}
		return null;
	}

	public static OrderStatusEnum getOrderStatus(int key) {
		for (OrderStatusEnum status : OrderStatusEnum.values()) {
			if (status.getKey() == key) {
				return status;
			}
		}
		return null;
	}

	public static boolean isCancelOrder(OrderStatusEnum targetStatus) {
		return null != targetStatus && targetStatus.key == Canceled.key;
	}

	public static OrderStatusEnum getStatusByCode(int code) {
		for (OrderStatusEnum status : OrderStatusEnum.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}

	/**
	 * 判断订单是否已完成：已完成和已取消的订单就算完成
	 * 
	 * @author flora
	 * @param order
	 * @return
	 */
	public static boolean isOrderFinished(OrderStatusEnum targetStatus) {
		boolean result = false;
		result = targetStatus == OrderCompleted || targetStatus == OrderFinished || targetStatus == UserConfirmed
				|| isCancelOrder(targetStatus);
		return result;
	}

}
