package com.selin.store.supplier.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_supplier <br/>
 *         描述：w_supplier <br/>
 */
public class Supplier implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// 主键
	protected String name;// 名称
	protected String linkman;// 联系人
	protected String linktel;// 联系电话
	protected String code;// 编码
	protected String address;// 地址
	protected String email;// email
	protected String remark;// 备注
	protected Long state;// 是否可用

	public Supplier() {
		super();
	}

	public Supplier(Long id) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	public String getLinktel() {
		return linktel;
	}
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
}
