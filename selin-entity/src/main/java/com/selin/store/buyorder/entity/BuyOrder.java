package com.selin.store.buyorder.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_buy_order <br/>
 *         描述：w_buy_order <br/>
 */
public class BuyOrder implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String buy_order_num;// 采购单编号
	protected Long supplier_id;// 供应商
	protected String current_event;// 采购单当前事件
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 创建日期
	protected String buyer;// 采购员
	protected String remark;// 备注
	protected Long create_user_id;// 制单人员编码
	protected Double other_amount;// 其它金额
	protected Double amount;// 总金额
	protected String order_num;// 订单编号

	public BuyOrder() {
		super();
	}

	public BuyOrder(Long id) {
		super();
		this.id = id;
	}
	
	@Id// 主键
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBuy_order_num() {
		return buy_order_num;
	}
	public void setBuy_order_num(String buy_order_num) {
		this.buy_order_num = buy_order_num;
	}
	
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	public String getCurrent_event() {
		return current_event;
	}
	public void setCurrent_event(String current_event) {
		this.current_event = current_event;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(Long create_user_id) {
		this.create_user_id = create_user_id;
	}
	
	public Double getOther_amount() {
		return other_amount;
	}
	public void setOther_amount(Double other_amount) {
		this.other_amount = other_amount;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
}
