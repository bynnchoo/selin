package com.selin.store.order.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.roof.commons.PropertiesUtil;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import org.roof.web.user.entity.User;
import org.roof.web.user.service.api.BaseUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderPrintVo;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;

import pdf.kit.OrderToPdf;

@Controller
@RequestMapping("selin/orderAction")
public class OrderAction {
	private IOrderService orderService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model) {
		List<Dictionary> dicList = dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	/**
	 * 发送订货单打印事件
	 * 
	 * @param orderNum
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/printOrderAuto")
	public @ResponseBody Result printOrderAuto(String orderNum, HttpServletRequest request, Model model)
			throws Exception {
		OrderPrintVo printvo = orderService.printOrderAuto(orderNum);
		// BaseUserContext.getCurrentUser(request));
		return new Result(Result.SUCCESS, printvo);
	}

	/**
	 * 页面订单打印，返回订货单打印数据
	 * 
	 * @param orderNum
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/printOrder")
	public @ResponseBody Result printOrder(String orderNum, HttpServletRequest request, Model model) throws Exception {
		OrderPrintVo printvo = orderService.printOrder(orderNum);
		// BaseUserContext.getCurrentUser(request));
		return new Result(Result.SUCCESS, printvo);
	}

	/**
	 * 导出订货单pdf
	 * 
	 * @param orderNum
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportOrder")
	public @ResponseBody Result exportOrderPdf(String orderNum, HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
		OrderPrintVo printvo = orderService.printOrder(orderNum);
		OrderToPdf kit = new OrderToPdf();
		String saveFilePath = kit.createPDF(printvo, PropertiesUtil.getPorjectProperty("pdf.path", String.class),
				printvo.getOrder_num());
		File file = new File(saveFilePath);
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
		BufferedInputStream bis = null;
		BufferedOutputStream out = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			while (true) {
				int bytesRead;
				if (-1 == (bytesRead = bis.read(buff, 0, buff.length))) {
					break;
				}
				out.write(buff, 0, bytesRead);
			}
			file.deleteOnExit();
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				throw e;
			}
		}
		return new Result(Result.SUCCESS);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/order/order_index.jsp";
	}

	@RequestMapping("/addBySales")
	public @ResponseBody Result orderAddBySales(OrderVo orderVo, HttpServletRequest request, Model model)
			throws Exception {
		Order o = orderService.orderAddBySales(orderVo, (User) BaseUserContext.getCurrentUser(request));
		return new Result(Result.SUCCESS, o);
	}

	@RequestMapping("/add")
	public @ResponseBody Result orderAdd(OrderVo orderVo, HttpServletRequest request, Model model) throws Exception {
		Order o = orderService.orderAdd(orderVo, (User) BaseUserContext.getCurrentUser(request));
		return new Result(Result.SUCCESS, o);
	}

	@RequestMapping("/confirm")
	public @ResponseBody Result orderConfirm(OrderVo orderVo, HttpServletRequest request, Model model)
			throws Exception {
		Order o = orderService.orderConfirm(orderVo, (User) BaseUserContext.getCurrentUser(request));
		return new Result(Result.SUCCESS, o);
	}

	@RequestMapping("/page")
	public @ResponseBody Result orderPage(OrderVo orderVo, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = orderService.selectOrderPageForSale(page, orderVo);
		return new Result(Result.SUCCESS, page);
	}

	/*
	 * @RequestMapping("/list") public String list(Order order,
	 * HttpServletRequest request, Model model) { Page page =
	 * PageUtils.createPage(request); page = orderService.page(page, order);
	 * model.addAttribute("page", page);
	 * model.addAllAttributes(PageUtils.createPagePar(page));
	 * this.loadCommon(model); return "/selin/order/order_list.jsp"; }
	 */

	@RequestMapping("/list")
	public @ResponseBody Result list(Order order, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = orderService.page(page, order);
		return new Result(Result.SUCCESS, page);
	}

	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		this.loadCommon(model);
		return "/selin/order/order_create.jsp";
	}

	@RequestMapping("/update_page")
	public String update_page(Order order, Model model) {
		order = orderService.load(order);
		model.addAttribute("order", order);
		this.loadCommon(model);
		return "/selin/order/order_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Order order, Model model) {
		order = orderService.load(order);
		model.addAttribute("order", order);
		this.loadCommon(model);
		return "/selin/order/order_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Order order) {
		if (order != null) {
			orderService.save(order);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}

	@RequestMapping("/update")
	public @ResponseBody Result update(Order order) {
		if (order != null) {
			orderService.updateIgnoreNull(order);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}

	@RequestMapping("/delete")
	public @ResponseBody Result delete(Order order) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		orderService.delete(order);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setOrderService(@Qualifier("orderService") IOrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
