package com.selin.store.order.entity;

import java.util.Date;
import java.util.List;

import com.selin.store.fileinfo.entity.Fileinfo;
import com.selin.store.invoice.entity.InvoiceVo;
import com.selin.store.orderevent.entity.OrderEventVo;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.entity.OrderProsVo;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.user.entity.Customer;

/**
 * @author 模版生成 <br/>
 *         表名： w_order <br/>
 *         描述：订单表 <br/>
 */
public class OrderVo extends Order {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8277814765661272632L;
	private List<OrderVo> orderList;

	private List<OrderPros> pros;// 产品信息
	private List<Fileinfo> files;// 附件列表

	// 返回用
	private List<OrderProsVo> proList;
	private List<OrderEventVo> eventList;
	private InvoiceVo invoice;// 发票信息
	private Customer cus;// 客户
	private ReceiveAddressVo address;// 收货信息

	// 查询用
	private List<String> payStatusList;// 多选付款状态

	private List<String> statusList;// 多选订货单状态

	private List<String> dispatchStatusList;// 多选 出库/发货 状态

	private Date start_date;

	private Date end_date;

	public OrderVo() {
		super();
	}

	public OrderVo(Long id) {
		super();
		this.id = id;
	}

	public List<OrderVo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVo> orderList) {
		this.orderList = orderList;
	}

	public List<OrderPros> getPros() {
		return pros;
	}

	public void setPros(List<OrderPros> pros) {
		this.pros = pros;
	}

	public List<Fileinfo> getFiles() {
		return files;
	}

	public void setFiles(List<Fileinfo> files) {
		this.files = files;
	}

	public List<String> getPayStatusList() {
		return payStatusList;
	}

	public void setPayStatusList(List<String> payStatusList) {
		this.payStatusList = payStatusList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<String> getDispatchStatusList() {
		return dispatchStatusList;
	}

	public void setDispatchStatusList(List<String> dispatchStatusList) {
		this.dispatchStatusList = dispatchStatusList;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public List<OrderProsVo> getProList() {
		return proList;
	}

	public void setProList(List<OrderProsVo> proList) {
		this.proList = proList;
	}

	public List<OrderEventVo> getEventList() {
		return eventList;
	}

	public void setEventList(List<OrderEventVo> eventList) {
		this.eventList = eventList;
	}

	public InvoiceVo getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceVo invoice) {
		this.invoice = invoice;
	}

	public ReceiveAddressVo getAddress() {
		return address;
	}

	public void setAddress(ReceiveAddressVo address) {
		this.address = address;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

}
