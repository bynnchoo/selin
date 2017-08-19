package pdf.kit;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.roof.commons.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdf.kit.component.PDFHeaderFooter;
import pdf.kit.component.PDFKit;

public class OrderToPdf {
	protected final Logger LOGGER = LoggerFactory.getLogger(OrderToPdf.class);

	public String createPDF(Object data, String fileName, String orderNum) {
		// pdf保存路径
		try {
			// 设置自定义PDF页眉页脚工具类
			PDFHeaderFooter headerFooter = new PDFHeaderFooter();
			PDFKit kit = new PDFKit();
			kit.setHeaderFooterBuilder(headerFooter);
			// 设置输出路径
			kit.setSaveFilePath(PropertiesUtil.getPorjectProperty("pdf.path", String.class) + orderNum + ".pdf");
			String saveFilePath = kit.exportToFile(fileName, data);
			return saveFilePath;
		} catch (Exception e) {
			LOGGER.error("PDF生成失败{" + ExceptionUtils.getFullStackTrace(e) + "}");
			return null;
		}
	}

}
