package com.selin.store.order.service.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.roof.commons.RoofDateUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.spring.Result;
import org.roof.web.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.selin.store.invoice.entity.InvoiceTypeEnum;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import com.selin.store.orderevent.entity.OrderStatusEnum;
import com.selin.store.orderpros.entity.OrderPros;

@ContextConfiguration(locations = { "classpath:spring.xml" })
public class OrderServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private IOrderService orderService;

	@Test
	public void testselectOrderPageForSale() {
		Page page = new Page();
		page.setLimit(10L);
		page.setCurrentPage(0L);
		OrderVo orderVo = new OrderVo();
		orderVo.setStart_date(RoofDateUtils.addDay(new Date(), -1));
		orderVo.setEnd_date(new Date());

		orderVo.setStatusList(Arrays.asList(
				new String[] { OrderStatusEnum.waitConfirm.getCode(), OrderStatusEnum.watiFinanceConfirm.getCode() }));

		orderService.selectOrderPageForSale(page, orderVo);
		for (Object o : page.getDataList()) {
			OrderVo vo = (OrderVo) o;
			System.out.println(vo.toString());
		}
	}

	@Test
	public void testOrderAddBySales() {
		OrderVo vo = this.createData(str);
		try {
			Order o = orderService.orderAddBySales(vo, new User(153L));
			System.out.println(o.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderAdd() {
		OrderVo vo = this.createData(str);
		try {
			Order o = orderService.orderAdd(vo, new User(153L));
			System.out.println(o.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderConfirm() {
		OrderVo vo = this.createData(strupdate);
		try {
			Order o = orderService.orderConfirm(vo, new User(153L));
			System.out.println(o.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderFinanceConfirm() {
		fail("Not yet implemented");
	}

	@Test
	public void testDispatchConfirm() {
		fail("Not yet implemented");
	}

	@Test
	public void testBack() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancel() {
		fail("Not yet implemented");
	}

	public static void main(String[] args) {
		List<OrderPros> list = new ArrayList<OrderPros>();
		OrderPros pro = new OrderPros();
		pro.setNum(10L);
		pro.setPrice(300D);
		pro.setPro_norms_id(1L);
		pro.setPro_name("s");
		pro.setRemark("haha");
		pro.setUnit("件");
		list.add(pro);

		OrderPros pro1 = new OrderPros();
		pro1.setNum(10L);
		pro1.setPrice(300D);
		pro1.setPro_norms_id(2L);
		pro1.setPro_name("s");
		pro1.setRemark("haha");
		pro1.setUnit("件");
		list.add(pro1);

		OrderVo vo = new OrderVo();
		vo.setPros(list);
		vo.setReceive_address_id(1L);
		vo.setCus_id(1L);
		vo.setEx_date(new Date());
		vo.setInvoice_type(InvoiceTypeEnum.normalInvoice.getCode());
		vo.setInvoice_id(1L);
		vo.setRemark("xxx");
		vo.setId(7L);
		vo.setOrder_num("DH-2017081605-000004");

		System.out.println(Result.getStr(vo));

	}

	String str = "{\"cus_id\":1,\"ex_date\":\"2017-08-16\",\"invoice_id\":1,\"invoice_type\":\"normalInvoice\",\"pros\":[{\"num\":10,\"price\":300,\"pro_name\":\"s\",\"pro_norms_id\":1,\"remark\":\"haha\",\"unit\":\"件\"},{\"num\":10,\"price\":300,\"pro_name\":\"s\",\"pro_norms_id\":2,\"remark\":\"haha\",\"unit\":\"件\"}],\"receive_address_id\":1,\"remark\":\"xxx\"}";

	String strupdate = "{\"order_num\":\"DH-2017081605-000004\",\"id\":6,\"cus_id\":1,\"ex_date\":\"2017-08-16\",\"invoice_id\":1,\"invoice_type\":\"normalInvoice\",\"pros\":[{\"num\":10,\"price\":290,\"pro_name\":\"s\",\"pro_norms_id\":1,\"remark\":\"haha\",\"unit\":\"件\"},{\"num\":10,\"price\":290,\"pro_name\":\"s\",\"pro_norms_id\":2,\"remark\":\"haha\",\"unit\":\"件\"}],\"receive_address_id\":1,\"remark\":\"xxx\"}";

	public OrderVo createData(String json) {
		OrderVo vo = JSON.parseObject(json, OrderVo.class);
		return vo;
	}
}
