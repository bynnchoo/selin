package com.selin.store.order.entity;

import java.util.List;

import org.roof.web.user.entity.User;

import com.selin.store.customer.entity.Customer;
import com.selin.store.fileinfo.entity.Fileinfo;
import com.selin.store.invoice.entity.Invoice;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.receiveaddress.entity.ReceiveAddress;

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
	// private Customer cus;// 客户
	private List<Fileinfo> files;// 附件列表
	// private ReceiveAddress address;// 收货信息
	// private Invoice invoice;// 发票信息

	private User currentUser;

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

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
