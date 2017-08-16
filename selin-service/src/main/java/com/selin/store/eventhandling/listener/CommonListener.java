package com.selin.store.eventhandling.listener;

import java.util.EventListener;

import com.selin.store.eventhandling.CommonEvent;

public interface CommonListener extends EventListener {

	void handleEvent(CommonEvent event) throws Exception;

}
