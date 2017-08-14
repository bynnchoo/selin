package com.selin.store.buyorderevent.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_buy_order_event <br/>
 *         描述：采购订单事件表 <br/>
 */
public class BuyOrderEventVo extends BuyOrderEvent {

	private List<BuyOrderEventVo> buyOrderEventList;

	public BuyOrderEventVo() {
		super();
	}

	public BuyOrderEventVo(Long id) {
		super();
		this.id = id;
	}

	public List<BuyOrderEventVo> getBuyOrderEventList() {
		return buyOrderEventList;
	}

	public void setBuyOrderEventList(List<BuyOrderEventVo> buyOrderEventList) {
		this.buyOrderEventList = buyOrderEventList;
	}

}
