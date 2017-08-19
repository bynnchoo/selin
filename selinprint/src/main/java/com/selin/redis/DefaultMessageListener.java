package com.selin.redis;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.roof.commons.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.selin.pdf.PDFToImage;
import com.selin.print.PrintServiceImpl;

import pdf.kit.OrderPrintVo;
import pdf.kit.OrderToPdf;

@Service("defaultMessageListener")
public class DefaultMessageListener implements MessageListener {
	protected final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageListener.class);

	@Override
	public void onMessage(Message message, byte[] pattern) {
		byte[] channel = message.getChannel();
		byte[] body = message.getBody();
		LOGGER.info(new String(channel) + "-->" + new String(body) + "-->" + new String(pattern));
		OrderPrintVo o = JSON.parseObject(new String(body), OrderPrintVo.class);

		OrderToPdf orderToPdf = new OrderToPdf();
		String path;
		try {
			path = orderToPdf.createPDF(o, PropertiesUtil.getPorjectProperty("templete.name", String.class),
					o.getOrder_num());

			if (StringUtils.isBlank(path)) {
				LOGGER.error("pdf生成失败:" + path);
				return;
			}
			PDFToImage pdfToImage = new PDFToImage();
			List<String> images = pdfToImage.pdftoIamge(3f, PropertiesUtil.getPorjectProperty("pdf.path", String.class),
					o.getOrder_num(), PropertiesUtil.getPorjectProperty("pdf.path", String.class));
			if (images.isEmpty()) {
				LOGGER.error("图片生成失败:" + path);
				return;
			}
			PrintServiceImpl printServiceImpl = new PrintServiceImpl();
			for (String string : images) {
				printServiceImpl.printImage(string, PropertiesUtil.getPorjectProperty("print.path", String.class));
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			// TODO 发送失败消息
		}
	}

}
