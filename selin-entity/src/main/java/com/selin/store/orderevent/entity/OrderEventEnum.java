package com.selin.store.orderevent.entity;

/**
 * 订货单事件类型
 * 
 * @author liht
 *
 */
public enum OrderEventEnum {

	orderAdd("orderAdd", "创建订货单", "O-A", "已提交订货单，等待订货单审核"), orderConfirm("orderConfirm", "订货单确认", "O-C",
			"订货单已通过订货单审核"), orderFinanceConfirm("orderFinanceConfirm", "财务确认", "O-FC",
					"订货单已通过财务审核"), dispatchConfirm("dispatchConfirm", "发货确认", "O-DC", "订货单已确认发货"), complete("complete",
							"完成", "O-SUCCES", "订货单已完成"), cancel("cancel", "取消", "O-CANCEL", "订货单取消"), back("back", "退回",
									"O-BACK", "订货单退回"), orderUpdate("orderUpdate", "更新订货单", "O-U", "变更明细");

	private String eventCode;// 事件编码

	private String eventName;// 事件名称

	private String codePrefix;

	private String remark;

	OrderEventEnum(String eventCode, String eventName, String codePrefix, String reamrk) {
		this.eventCode = eventCode;
		this.eventName = eventName;
		this.codePrefix = codePrefix;
		this.remark = reamrk;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCodePrefix() {
		return codePrefix;
	}

	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
