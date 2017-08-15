package com.selin.store.returnorder.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_return_order <br/>
 *         描述：w_return_order <br/>
 */
public class ReturnOrder implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String return_order_num;// 退货单编号
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 下单时间
	protected Long cus_id;// 客户id
	protected String cus_num;// 客户编码
	protected String cus_name;// 客户名称
	protected Double amount;// 总金额
	protected String current_status;// 订单当前状态
	protected String current_event;// 订单当前事件
	protected String order_num;// 关联订单编号
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date complete_date;// 完成时间

	public ReturnOrder() {
		super();
	}

	public ReturnOrder(Long id) {
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
	
	public String getReturn_order_num() {
		return return_order_num;
	}
	public void setReturn_order_num(String return_order_num) {
		this.return_order_num = return_order_num;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public Long getCus_id() {
		return cus_id;
	}
	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}
	
	public String getCus_num() {
		return cus_num;
	}
	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}
	
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getCurrent_status() {
		return current_status;
	}
	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}
	
	public String getCurrent_event() {
		return current_event;
	}
	public void setCurrent_event(String current_event) {
		this.current_event = current_event;
	}
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	
	public Date getComplete_date() {
		return complete_date;
	}
	public void setComplete_date(Date complete_date) {
		this.complete_date = complete_date;
	}
}
