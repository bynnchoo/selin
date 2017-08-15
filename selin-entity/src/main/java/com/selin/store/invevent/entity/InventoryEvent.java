package com.selin.store.invevent.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event <br/>
 *         描述：库存事件表 <br/>
 */
public class InventoryEvent implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String event;// 事件
	protected String event_type;// 事件类型
	protected String event_code;// 事件编码
	protected Long in_warehouse_id;// 调入仓库\预占仓库
	protected Long out_warehouse_id;// 调出仓库
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date in_date;// 入仓库时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date out_date;// 出仓库时间
	protected Long create_user_id;// 操作人
	protected String status;// 状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date per_use_start_date;// 预占开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date per_use_end_date;// 预占结束时间
	protected String order_num;// 采购单、销售单、退货单编号
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 记录创建时间

	public InventoryEvent() {
		super();
	}

	public InventoryEvent(Long id) {
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
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
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
	
	public Long getIn_warehouse_id() {
		return in_warehouse_id;
	}
	public void setIn_warehouse_id(Long in_warehouse_id) {
		this.in_warehouse_id = in_warehouse_id;
	}
	
	public Long getOut_warehouse_id() {
		return out_warehouse_id;
	}
	public void setOut_warehouse_id(Long out_warehouse_id) {
		this.out_warehouse_id = out_warehouse_id;
	}
	
	public Date getIn_date() {
		return in_date;
	}
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	
	public Date getOut_date() {
		return out_date;
	}
	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}
	
	public Long getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(Long create_user_id) {
		this.create_user_id = create_user_id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getPer_use_start_date() {
		return per_use_start_date;
	}
	public void setPer_use_start_date(Date per_use_start_date) {
		this.per_use_start_date = per_use_start_date;
	}
	
	public Date getPer_use_end_date() {
		return per_use_end_date;
	}
	public void setPer_use_end_date(Date per_use_end_date) {
		this.per_use_end_date = per_use_end_date;
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
}
