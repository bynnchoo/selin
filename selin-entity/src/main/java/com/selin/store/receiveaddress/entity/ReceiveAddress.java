package com.selin.store.receiveaddress.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_receive_address <br/>
 *         描述：收货地址表 <br/>
 */
public class ReceiveAddress implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long cus_id;// 客户主键
	protected String cus_num;// 客户编码
	protected String cus_name;// 客户名称
	protected String receive_name;// 收货人
	protected String passcode;// 邮编
	protected String tel;// 联系方式
	protected String address;// 收货地址

	public ReceiveAddress() {
		super();
	}

	public ReceiveAddress(Long id) {
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
	
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
