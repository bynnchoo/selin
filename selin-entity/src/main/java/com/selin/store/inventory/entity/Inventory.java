package com.selin.store.inventory.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory <br/>
 *         描述：库存信息表 <br/>
 */
public class Inventory implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long pro_norms_id;// 商品规格
	protected String unit;// 单位
	protected Long warehouse_id;// 仓库id
	protected String warehouse_code;// 仓库编码
	protected Integer num;// 数量
	protected String upper_limit;// 库存上限
	protected String lower_limit;// 库存下限
	protected Integer mini_num;// 起订量

	public Inventory() {
		super();
	}

	public Inventory(Long id) {
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
	
	public Long getPro_norms_id() {
		return pro_norms_id;
	}
	public void setPro_norms_id(Long pro_norms_id) {
		this.pro_norms_id = pro_norms_id;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Long getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(Long warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	
	public String getWarehouse_code() {
		return warehouse_code;
	}
	public void setWarehouse_code(String warehouse_code) {
		this.warehouse_code = warehouse_code;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String getUpper_limit() {
		return upper_limit;
	}
	public void setUpper_limit(String upper_limit) {
		this.upper_limit = upper_limit;
	}
	
	public String getLower_limit() {
		return lower_limit;
	}
	public void setLower_limit(String lower_limit) {
		this.lower_limit = lower_limit;
	}
	
	public Integer getMini_num() {
		return mini_num;
	}
	public void setMini_num(Integer mini_num) {
		this.mini_num = mini_num;
	}
}
