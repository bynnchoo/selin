package com.selin.store.order.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_order <br/>
 *         描述：订单表 <br/>
 */
public class Order implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8614100056837097388L;
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String order_num;// 订单编号
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 下单时间
	protected Long cus_id;// 客户编号
	protected String cus_num;// 客户编码
	protected String cus_name;// 客户名称
	protected String amount;// 总金额
	protected String current_status;// 订单当前状态
	protected String current_event;// 订单当前事件
	protected String pay_status;// 付款状态
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date finish_time;// 完成时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date ex_date;// 交货日期
	protected String remark;// 备注
	protected Long receive_address_id;// 收货地址
	protected String invoice_type;// 发票类型
	protected Long invoice_id;// 发票信息id
	protected String dispatch_status;// 出库/发货状态

	public Order() {
		super();
	}

	public Order(Long id) {
		super();
		this.id = id;
	}

	@Id // 主键
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public Date getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}

	public Date getEx_date() {
		return ex_date;
	}

	public void setEx_date(Date ex_date) {
		this.ex_date = ex_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getReceive_address_id() {
		return receive_address_id;
	}

	public void setReceive_address_id(Long receive_address_id) {
		this.receive_address_id = receive_address_id;
	}

	public String getInvoice_type() {
		return invoice_type;
	}

	public void setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
	}

	public Long getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Long invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getDispatch_status() {
		return dispatch_status;
	}

	public void setDispatch_status(String dispatch_status) {
		this.dispatch_status = dispatch_status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_num=" + order_num + ", create_date=" + create_date + ", cus_id=" + cus_id
				+ ", cus_num=" + cus_num + ", cus_name=" + cus_name + ", amount=" + amount + ", current_status="
				+ current_status + ", current_event=" + current_event + ", pay_status=" + pay_status + ", finish_time="
				+ finish_time + ", ex_date=" + ex_date + ", remark=" + remark + ", receive_address_id="
				+ receive_address_id + ", invoice_type=" + invoice_type + ", invoice_id=" + invoice_id
				+ ", dispatch_status=" + dispatch_status + "]";
	}
}
