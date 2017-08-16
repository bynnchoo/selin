package com.selin.store.orderevent.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_order_event <br/>
 *         描述：订单事件表 <br/>
 */
public class OrderEvent implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String order_num;// 订单编号或退单编号
	protected String event_type;// 事件类型
	protected String event_code;// 事件编码
	protected String event;// 事件
	protected String event_name;// 事件名称
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 事件发生时间
	protected String reamrk;// 操作日志
	protected Long create_user_id;// 操作人

	public OrderEvent() {
		super();
	}

	public OrderEvent(Long id) {
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
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	public String getEvent_code() {
		return event_code;
	}
	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public String getReamrk() {
		return reamrk;
	}
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
	
	public Long getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(Long create_user_id) {
		this.create_user_id = create_user_id;
	}
}
