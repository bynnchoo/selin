package com.selin.store.dispatchorder.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_dispatch_order <br/>
 *         描述：发货单 <br/>
 */
public class DispatchOrder implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String order_num;// 销售单编号
	protected String dispatch_order_num;// 发货单编码
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date dispatch_date;// 发货日期
	protected String logistics_company;// 物流公司
	protected String logistics_num;// 物流单号
	protected String logistics_remark;// 物流备注

	public DispatchOrder() {
		super();
	}

	public DispatchOrder(Long id) {
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
	
	public String getDispatch_order_num() {
		return dispatch_order_num;
	}
	public void setDispatch_order_num(String dispatch_order_num) {
		this.dispatch_order_num = dispatch_order_num;
	}
	
	public Date getDispatch_date() {
		return dispatch_date;
	}
	public void setDispatch_date(Date dispatch_date) {
		this.dispatch_date = dispatch_date;
	}
	
	public String getLogistics_company() {
		return logistics_company;
	}
	public void setLogistics_company(String logistics_company) {
		this.logistics_company = logistics_company;
	}
	
	public String getLogistics_num() {
		return logistics_num;
	}
	public void setLogistics_num(String logistics_num) {
		this.logistics_num = logistics_num;
	}
	
	public String getLogistics_remark() {
		return logistics_remark;
	}
	public void setLogistics_remark(String logistics_remark) {
		this.logistics_remark = logistics_remark;
	}
}
