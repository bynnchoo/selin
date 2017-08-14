package com.selin.store.buyorderpros.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_buy_order_pros <br/>
 *         描述：采购单商品表 <br/>
 */
public class BuyOrderProsVo extends BuyOrderPros {

	private List<BuyOrderProsVo> buyOrderProsList;

	public BuyOrderProsVo() {
		super();
	}

	public BuyOrderProsVo(Long id) {
		super();
		this.id = id;
	}

	public List<BuyOrderProsVo> getBuyOrderProsList() {
		return buyOrderProsList;
	}

	public void setBuyOrderProsList(List<BuyOrderProsVo> buyOrderProsList) {
		this.buyOrderProsList = buyOrderProsList;
	}

}
