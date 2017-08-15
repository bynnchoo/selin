package com.selin.store.buyorder.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_buy_order <br/>
 *         描述：w_buy_order <br/>
 */
public class BuyOrderVo extends BuyOrder {

	private List<BuyOrderVo> buyOrderList;

	public BuyOrderVo() {
		super();
	}

	public BuyOrderVo(Long id) {
		super();
		this.id = id;
	}

	public List<BuyOrderVo> getBuyOrderList() {
		return buyOrderList;
	}

	public void setBuyOrderList(List<BuyOrderVo> buyOrderList) {
		this.buyOrderList = buyOrderList;
	}

}
