package com.selin.store.inveventhis.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event_his <br/>
 *         描述：w_inventory_event_his <br/>
 */
public class InventoryEventHisVo extends InventoryEventHis {

	private List<InventoryEventHisVo> inventoryEventHisList;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date beginDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date endDate;


	private String product_name;
	private String product_code;
	private String colour;
	private String size;
	private Integer num;
	private Integer his_num;

	private String in_warehouse_name;
	private String out_warehouse_name;

	public InventoryEventHisVo() {
		super();
	}

	public InventoryEventHisVo(Long id) {
		super();
		this.id = id;
	}

	public List<InventoryEventHisVo> getInventoryEventHisList() {
		return inventoryEventHisList;
	}

	public void setInventoryEventHisList(List<InventoryEventHisVo> inventoryEventHisList) {
		this.inventoryEventHisList = inventoryEventHisList;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getHis_num() {
		return his_num;
	}

	public void setHis_num(Integer his_num) {
		this.his_num = his_num;
	}

	public String getIn_warehouse_name() {
		return in_warehouse_name;
	}

	public void setIn_warehouse_name(String in_warehouse_name) {
		this.in_warehouse_name = in_warehouse_name;
	}

	public String getOut_warehouse_name() {
		return out_warehouse_name;
	}

	public void setOut_warehouse_name(String out_warehouse_name) {
		this.out_warehouse_name = out_warehouse_name;
	}
}
