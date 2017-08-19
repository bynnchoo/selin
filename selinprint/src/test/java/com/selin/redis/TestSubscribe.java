package com.selin.redis;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;

import pdf.kit.OrderPrintPros;
import pdf.kit.OrderPrintVo;

@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestSubscribe extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	@Test
	public void testSubscribe() throws Exception {
		// redisTemplate.getConnectionFactory().getConnection().publish("gsn".getBytes(),
		// "1231231231".getBytes());
		// redisTemplate.boundValueOps("abc1").set("123");
		Map<String, String> map = new HashMap<String, String>();

		map.put("order_id", "123");
		map.put("print_id", "中文");
		map.put("print_ids", "大神123");

		redisTemplate.convertAndSend("gsn", JSON.toJSONString(map));
	}

	@Test
	public void test() throws IOException {
		// OrderToPdf orderToPdf = new OrderToPdf();
		OrderPrintVo o = new OrderPrintVo();
		o.setAddress("浙江杭州");
		o.setAmount("1000.00");
		o.setCreate_date("2017-08-09 09:02:02");
		o.setCus_name("中文");
		o.setEx_date("2017-08-09 09:02:02");
		o.setNumCount(30L);
		o.setOrder_num("DH-O-20170806-036984");
		o.setReceive_name("郑天天");
		o.setTel("sbt天天的电话");

		List<OrderPrintPros> pros = new ArrayList<OrderPrintPros>();
		for (int i = 0; i < 10; i++) {
			OrderPrintPros v1 = new OrderPrintPros();
			v1.setAmount(100D);
			v1.setNum(5L);
			v1.setPrice(100D);
			v1.setPro_code("P1714510057");
			v1.setPro_name("M-608");
			v1.setPro_norms_name("颜色：红色，尺码：L");
			v1.setRemark("sbt是郑天");
			v1.setUnit("件");
			pros.add(v1);
		}
		o.setPros(pros);

		redisTemplate.convertAndSend("orderPrint-A", JSON.toJSONString(o));
		// String path = orderToPdf.createPDF(o,
		// PropertiesUtil.getPorjectProperty("templete.name", String.class),
		// o.getOrder_num());
		// if (StringUtils.isBlank(path)) {
		// System.out.println("pdf生成失败:" + path);
		// return;
		// }
		// PDFToImage pdfToImage = new PDFToImage();
		// List<String> images = pdfToImage.pdftoIamge(3f,
		// PropertiesUtil.getPorjectProperty("pdf.path", String.class),
		// o.getOrder_num(), PropertiesUtil.getPorjectProperty("pdf.path",
		// String.class));
		// if (images.isEmpty()) {
		// System.out.println("图片生成失败:" + path);
		// return;
		// }
		// PrintServiceImpl printServiceImpl = new PrintServiceImpl();
		// for (String string : images) {
		// printServiceImpl.printImage(string,
		// PropertiesUtil.getPorjectProperty("print.path", String.class));
		// }
	}

}
