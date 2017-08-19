package com.selin.store.order.entity;

import java.util.List;

public class OrderPrintVo {
	protected String order_num;// 订单编号
	protected String create_date;// 下单时间
	protected String ex_date;// 交货日期
	protected String cus_name;// 客户名称
	private String address;// 收货地址
	private String receive_name;// 收货人
	private String tel;//
	private List<OrderPrintPros> pros;// 收货明细
	private Long numCount;// 合计数量
	protected String amount;// 总金额
	protected Long sale_id;

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getEx_date() {
		return ex_date;
	}

	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<OrderPrintPros> getPros() {
		return pros;
	}

	public void setPros(List<OrderPrintPros> pros) {
		this.pros = pros;
	}

	public Long getNumCount() {
		return numCount;
	}

	public void setNumCount(Long numCount) {
		this.numCount = numCount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getSale_id() {
		return sale_id;
	}

	public void setSale_id(Long sale_id) {
		this.sale_id = sale_id;
	}

}
