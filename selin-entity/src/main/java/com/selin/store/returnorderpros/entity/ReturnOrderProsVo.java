package com.selin.store.returnorderpros.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_return_order_pros <br/>
 *         描述：订单商品表 <br/>
 */
public class ReturnOrderProsVo extends ReturnOrderPros {

	private List<ReturnOrderProsVo> returnOrderProsList;

	public ReturnOrderProsVo() {
		super();
	}

	public ReturnOrderProsVo(Long id) {
		super();
		this.id = id;
	}

	public List<ReturnOrderProsVo> getReturnOrderProsList() {
		return returnOrderProsList;
	}

	public void setReturnOrderProsList(List<ReturnOrderProsVo> returnOrderProsList) {
		this.returnOrderProsList = returnOrderProsList;
	}

}
