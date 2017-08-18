package com.selin.store.inveventdetail.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event_pro_detail <br/>
 *         描述：仓库事件商品明细 <br/>
 */
public class InventoryEventProDetail implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long norm_id;// 商品规格id
	protected String event_code;// 事件编码
	protected Integer num;// 数量
	protected Integer his_num;

	public InventoryEventProDetail() {
		super();
	}

	public InventoryEventProDetail(Long id) {
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
	
	public Long getNorm_id() {
		return norm_id;
	}
	public void setNorm_id(Long norm_id) {
		this.norm_id = norm_id;
	}
	
	public String getEvent_code() {
		return event_code;
	}
	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public void setHis_num(Integer his_num) {
		this.his_num = his_num;
	}

	public Integer getHis_num() {
		return his_num;
	}
}
