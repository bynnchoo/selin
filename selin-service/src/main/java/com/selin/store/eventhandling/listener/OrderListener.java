package com.selin.store.eventhandling.listener;

import org.springframework.stereotype.Service;

import com.selin.store.eventhandling.CommonEvent;

@Service
public class OrderListener implements CommonListener {

	@Override
	public void handleEvent(CommonEvent event) throws Exception {
		System.out.println("123123123");
		event.handler();
	}

}
