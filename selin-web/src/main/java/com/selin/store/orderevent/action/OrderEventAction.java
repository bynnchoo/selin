package com.selin.store.orderevent.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventVo;
import com.selin.store.orderevent.service.api.IOrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/ordereventAction")
public class OrderEventAction {
	private IOrderEventService orderEventService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/orderEvent/orderEvent_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(OrderEvent orderEvent, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = orderEventService.page(page, orderEvent);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/orderEvent/orderEvent_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(OrderEvent orderEvent, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = orderEventService.page(page, orderEvent);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		OrderEvent orderEvent = new OrderEvent();
		model.addAttribute("orderEvent", orderEvent);
		this.loadCommon(model);
		return "/selin/orderEvent/orderEvent_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(OrderEvent orderEvent, Model model) {
		orderEvent = orderEventService.load(orderEvent);
		model.addAttribute("orderEvent", orderEvent);
		this.loadCommon(model);
		return "/selin/orderEvent/orderEvent_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(OrderEvent orderEvent, Model model) {
		orderEvent = orderEventService.load(orderEvent);
		model.addAttribute("orderEvent", orderEvent);
		this.loadCommon(model);
		return "/selin/orderEvent/orderEvent_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(OrderEvent orderEvent) {
		if (orderEvent != null) {
			orderEventService.save(orderEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(OrderEvent orderEvent) {
		if (orderEvent != null) {
			orderEventService.updateIgnoreNull(orderEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(OrderEvent orderEvent) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		orderEventService.delete(orderEvent);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setOrderEventService(
			@Qualifier("orderEventService") IOrderEventService orderEventService) {
		this.orderEventService = orderEventService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
