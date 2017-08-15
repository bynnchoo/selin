package com.selin.store.orderpros.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_order_pros <br/>
 *         描述：订单商品表 <br/>
 */
public class OrderProsVo extends OrderPros {

	private List<OrderProsVo> orderProsList;

	public OrderProsVo() {
		super();
	}

	public OrderProsVo(Long id) {
		super();
		this.id = id;
	}

	public List<OrderProsVo> getOrderProsList() {
		return orderProsList;
	}

	public void setOrderProsList(List<OrderProsVo> orderProsList) {
		this.orderProsList = orderProsList;
	}

}
