package com.selin.store.returnorder.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_return_order <br/>
 *         描述：w_return_order <br/>
 */
public class ReturnOrderVo extends ReturnOrder {

	private List<ReturnOrderVo> returnOrderList;

	public ReturnOrderVo() {
		super();
	}

	public ReturnOrderVo(Long id) {
		super();
		this.id = id;
	}

	public List<ReturnOrderVo> getReturnOrderList() {
		return returnOrderList;
	}

	public void setReturnOrderList(List<ReturnOrderVo> returnOrderList) {
		this.returnOrderList = returnOrderList;
	}

}
