package com.selin.print;

import java.io.File;
import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("printServiceImpl")
public class PrintServiceImpl {
	protected final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

	public void printImage(String path, String printServer) {
		File file = new File(path); // 获取选择的文件
		// 构建打印请求属性集
		HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		// 设置打印格式，因为未确定类型，所以选择autosense
		DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
		// DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// 查找所有的可用的打印服务
		PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
		// System.out.println("-------------------All
		// services-------------------");
		// for (int i = 0; i < printService.length; i++) {
		// LOGGER.debug(printService[i].getName());
		// System.out.println(printService[i]);
		// }
		// 定位默认的打印服务
		if (printService.length > 0) {
			// System.out.println("-------------------Choose
			// Printer-------------------");
			// System.out.println(printService[0]);
			// 指定使用 Microsoft XPS Document Writer
			PrintService service = null;
			for (PrintService ps : printService) {
				if (ps.getName().endsWith(printServer)) {
					service = ps;
					break;
				}
			}
			// 获取打印机属性
			AttributeSet attributes = service.getAttributes();
			for (Attribute a : attributes.toArray()) {
				String name = a.getName();
				String value = attributes.get(a.getClass()).toString();
				LOGGER.info(name + " : " + value);
			}
			// 显示打印对话框
			// PrintService service = ServiceUI.printDialog(null, 200, 200,
			// printService,
			// service1, flavor, pras);
			if (service != null) {
				try {
					System.out.println("Begin Print PDF: " + file.getName());
					DocPrintJob job = service.createPrintJob(); // 创建打印作业
					FileInputStream fis = new FileInputStream(file); // 构造待打印的文件流
					DocAttributeSet das = new HashDocAttributeSet();
					// 请求一个彩色打印机
					// pras.add(Chromaticity.COLOR);
					// 请求横向模式
					// pras.add(OrientationRequested.LANDSCAPE);
					// 美国Letter大小的纸质属性
					// pras.add(MediaSizeName.NA_LETTER);
					// European A4 paper
					// pras.add(MediaSizeName.ISO_A4);
					// 请求装订
					// pras.add(Finishings.STAPLE);
					// 整理多个副本
					// pras.add(SheetCollate.COLLATED);
					// 请求双面
					// pras.add(Sides.DUPLEX);
					// 2页到一个工作表
					// pras.add(new NumberUp(1));
					// 多少个副本
					pras.add(new Copies(1));
					Doc doc = new SimpleDoc(fis, flavor, das);
					job.print(doc, pras);
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}

}
