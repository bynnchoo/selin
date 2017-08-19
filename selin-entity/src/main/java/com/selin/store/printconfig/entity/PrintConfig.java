package com.selin.store.printconfig.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_print_config <br/>
 *         描述：用户监听哪些频道消息 <br/>
 */
public class PrintConfig implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long user_id;// 用户id
	protected String channel;// 消息频道
	protected Long org_id;// 组织id
	protected String print_type;// 打印类型(订单、等)

	public PrintConfig() {
		super();
	}

	public PrintConfig(Long id) {
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
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public Long getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}
	
	public String getPrint_type() {
		return print_type;
	}
	public void setPrint_type(String print_type) {
		this.print_type = print_type;
	}
}
