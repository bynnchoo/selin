package com.selin.store.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/orderAction")
public class OrderAction {
	private IOrderService orderService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/order/order_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Order order, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = orderService.page(page, order);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/order/order_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Order order, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = orderService.page(page, order);
    return new Result(Result.SUCCESS,page);
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
	public void setOrderService(
			@Qualifier("orderService") IOrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
