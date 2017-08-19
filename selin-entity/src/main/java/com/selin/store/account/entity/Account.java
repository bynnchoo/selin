package com.selin.store.account.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_account <br/>
 *         描述：w_account <br/>
 */
public class Account implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long user_id;// 用户
	protected Double balance;// 余额
	protected Double max_debt;// 最大欠款
	protected Integer status;// 状态
	protected String code;// 资金账号

	public Account() {
		super();
	}

	public Account(Long id) {
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
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getMax_debt() {
		return max_debt;
	}
	public void setMax_debt(Double max_debt) {
		this.max_debt = max_debt;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
