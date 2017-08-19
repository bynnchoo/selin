package com.selin.store.accountserial.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_account_serial <br/>
 *         描述：w_account_serial <br/>
 */
public class AccountSerial implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date deal_time;// 交易时间
	protected Long account_id;// 账户id
	protected Long user_id;// 用户id
	protected Double money;// 金额
	protected Double his_balance;// 当前余额
	protected String pay_way;// 付款方式
	protected Long audit_user_id;// 审核人员
	protected String remark;// 备注
	protected String serial_number;// 流水号
	protected Long operate_user_id;// 操作人员
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date operate_time;// 操作时间
	protected String account_credited;// 收款账户
	protected String pay_serial_number;// 交易流水号
	protected String account_code;// account_code

	public AccountSerial() {
		super();
	}

	public AccountSerial(Long id) {
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
	
	public Date getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}
	
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	public Double getHis_balance() {
		return his_balance;
	}
	public void setHis_balance(Double his_balance) {
		this.his_balance = his_balance;
	}
	
	public String getPay_way() {
		return pay_way;
	}
	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}
	
	public Long getAudit_user_id() {
		return audit_user_id;
	}
	public void setAudit_user_id(Long audit_user_id) {
		this.audit_user_id = audit_user_id;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	
	public Long getOperate_user_id() {
		return operate_user_id;
	}
	public void setOperate_user_id(Long operate_user_id) {
		this.operate_user_id = operate_user_id;
	}
	
	public Date getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
	
	public String getAccount_credited() {
		return account_credited;
	}
	public void setAccount_credited(String account_credited) {
		this.account_credited = account_credited;
	}
	
	public String getPay_serial_number() {
		return pay_serial_number;
	}
	public void setPay_serial_number(String pay_serial_number) {
		this.pay_serial_number = pay_serial_number;
	}
	
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}
}
