package com.selin.store.returnorderpros.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_return_order_pros <br/>
 *         描述：订单商品表 <br/>
 */
public class ReturnOrderPros implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String return_order_num;// 退单编号
	protected Long pro_norms_id;// 商品规格
	protected String pro_name;// 商品名称
	protected Long num;// 数量
	protected String unit;// 单位
	protected Double price;// 单价
	protected String remark;// 备注

	public ReturnOrderPros() {
		super();
	}

	public ReturnOrderPros(Long id) {
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
	
	public String getReturn_order_num() {
		return return_order_num;
	}
	public void setReturn_order_num(String return_order_num) {
		this.return_order_num = return_order_num;
	}
	
	public Long getPro_norms_id() {
		return pro_norms_id;
	}
	public void setPro_norms_id(Long pro_norms_id) {
		this.pro_norms_id = pro_norms_id;
	}
	
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
