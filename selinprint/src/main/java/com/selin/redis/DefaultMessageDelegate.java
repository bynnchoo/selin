package com.selin.redis;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

public class DefaultMessageDelegate implements MessageDelegate {
	protected final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageDelegate.class);

	public void handleMessage(String message) {
		LOGGER.info("--------handleMessage 1-----------");
		LOGGER.info(message);
	}

	@Override
	public void handleMessage(Map message) {
		LOGGER.info("--------handleMessage 2-----------");
		LOGGER.info(message.toString());
	}

	@Override
	public void handleMessage(byte[] message) {
		LOGGER.info("--------handleMessage 3-----------");
		LOGGER.info(new String(message));
	}

	public void handleMessage(Serializable message) {
		LOGGER.info("--------handleMessage 4-----------");
		LOGGER.info(message.toString());
	}

	public void handleMessage(Serializable message, String channel) {
		LOGGER.info("--------handleMessage 5-----------");
		LOGGER.info(message + "------>" + channel);
	}

}
