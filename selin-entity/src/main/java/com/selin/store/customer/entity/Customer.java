package com.selin.store.customer.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_customer <br/>
 *         描述：客户表 <br/>
 */
public class Customer implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String cus_num;// 客户名称
	protected String cus_name;// 客户编码
	protected String cus_type;// 客户类型标识
	protected String has_credit;// 客户赊账标识
	protected Double credit_amount;// 赊账额度
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date create_date;// 创建时间
	protected Long default_address;// 默认收货地址

	public Customer() {
		super();
	}

	public Customer(Long id) {
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
	
	public String getCus_type() {
		return cus_type;
	}
	public void setCus_type(String cus_type) {
		this.cus_type = cus_type;
	}
	
	public String getHas_credit() {
		return has_credit;
	}
	public void setHas_credit(String has_credit) {
		this.has_credit = has_credit;
	}
	
	public Double getCredit_amount() {
		return credit_amount;
	}
	public void setCredit_amount(Double credit_amount) {
		this.credit_amount = credit_amount;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public Long getDefault_address() {
		return default_address;
	}
	public void setDefault_address(Long default_address) {
		this.default_address = default_address;
	}
}
