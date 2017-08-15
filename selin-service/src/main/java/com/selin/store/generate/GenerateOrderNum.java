package com.selin.store.generate;

import java.util.Date;

import com.selin.store.common.DateUtil;
import com.selin.store.orderevent.entity.OrderEnum;

public class GenerateOrderNum {

	private final static String SEPARATE_CHAR = "-";

	public synchronized static String generate(String tag) {
		Date d = new Date();
		return tag + SEPARATE_CHAR + DateUtil.formatToString(d, DateUtil.YYYYMMDD) + SEPARATE_CHAR
				+ DateUtil.formatToString(d, DateUtil.HHMMSS);
	}

	public static void main(String[] args) {
		System.out.println(GenerateOrderNum.generate(OrderEnum.buyOrder.getCodePrefix()));
	}

}
