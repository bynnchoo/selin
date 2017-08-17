package com.selin.store.receiveaddress.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.selin.store.receiveaddress.entity.ReceiveAddress;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.receiveaddress.service.api.IReceiveAddressService;

@ContextConfiguration(locations = { "classpath:spring.xml" })
public class ReceiveAddressServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private IReceiveAddressService receiveAddressService;

	@Test
	public void testSelectForList() {
		ReceiveAddress receiveAddress = new ReceiveAddress();
		receiveAddress.setCus_id(1L);
		List<ReceiveAddressVo> vos = receiveAddressService.selectForList(receiveAddress);
		for (ReceiveAddressVo v : vos) {
			System.out.println(v.toString());
		}
	}

}
