package com.selin.store.dispatchorderpros.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_dispatch_order_pros <br/>
 *         描述：发货单商品表 <br/>
 */
public class DispatchOrderProsVo extends DispatchOrderPros {

	private List<DispatchOrderProsVo> dispatchOrderProsList;

	public DispatchOrderProsVo() {
		super();
	}

	public DispatchOrderProsVo(Long id) {
		super();
		this.id = id;
	}

	public List<DispatchOrderProsVo> getDispatchOrderProsList() {
		return dispatchOrderProsList;
	}

	public void setDispatchOrderProsList(List<DispatchOrderProsVo> dispatchOrderProsList) {
		this.dispatchOrderProsList = dispatchOrderProsList;
	}

}
