package com.selin.store.invoice.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_invoice <br/>
 *         描述：w_invoice <br/>
 */
public class Invoice implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String invoice_type;// 发票类型
	protected String heard;// 发票抬头
	protected String taxpayer_num;// 纳税人识别号
	protected String address;// 地址
	protected String tel;// 电弧
	protected String bank;// 开户行
	protected String card_num;// 银行账号
	protected Long cus_id;// 客户id

	public Invoice() {
		super();
	}

	public Invoice(Long id) {
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
	
	public String getInvoice_type() {
		return invoice_type;
	}
	public void setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
	}
	
	public String getHeard() {
		return heard;
	}
	public void setHeard(String heard) {
		this.heard = heard;
	}
	
	public String getTaxpayer_num() {
		return taxpayer_num;
	}
	public void setTaxpayer_num(String taxpayer_num) {
		this.taxpayer_num = taxpayer_num;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	
	public Long getCus_id() {
		return cus_id;
	}
	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}
}
