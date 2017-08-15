package com.selin.store.dispatchorder.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_dispatch_order <br/>
 *         描述：发货单 <br/>
 */
public class DispatchOrderVo extends DispatchOrder {

	private List<DispatchOrderVo> dispatchOrderList;

	public DispatchOrderVo() {
		super();
	}

	public DispatchOrderVo(Long id) {
		super();
		this.id = id;
	}

	public List<DispatchOrderVo> getDispatchOrderList() {
		return dispatchOrderList;
	}

	public void setDispatchOrderList(List<DispatchOrderVo> dispatchOrderList) {
		this.dispatchOrderList = dispatchOrderList;
	}

}
