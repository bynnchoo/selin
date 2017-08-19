package com.selin.store.order.entity;

public class OrderPrintPros {
	private String pro_code;// 商品编码
	protected String pro_norms_name;// 商品规格
	protected String pro_name;// 商品名称
	protected Long num;// 数量
	protected String unit;// 单位
	protected Double price;// 单价
	protected String remark;// 备注
	private Double amount;// 合计

	public String getPro_norms_name() {
		return pro_norms_name;
	}

	public void setPro_norms_name(String pro_norms_name) {
		this.pro_norms_name = pro_norms_name;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}
}
