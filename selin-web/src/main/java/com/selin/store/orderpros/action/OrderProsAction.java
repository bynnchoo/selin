package com.selin.store.orderpros.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.entity.OrderProsVo;
import com.selin.store.orderpros.service.api.IOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/orderprosAction")
public class OrderProsAction {
	private IOrderProsService orderProsService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/orderPros/orderPros_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(OrderPros orderPros, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = orderProsService.page(page, orderPros);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/orderPros/orderPros_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(OrderPros orderPros, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = orderProsService.page(page, orderPros);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		OrderPros orderPros = new OrderPros();
		model.addAttribute("orderPros", orderPros);
		this.loadCommon(model);
		return "/selin/orderPros/orderPros_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(OrderPros orderPros, Model model) {
		orderPros = orderProsService.load(orderPros);
		model.addAttribute("orderPros", orderPros);
		this.loadCommon(model);
		return "/selin/orderPros/orderPros_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(OrderPros orderPros, Model model) {
		orderPros = orderProsService.load(orderPros);
		model.addAttribute("orderPros", orderPros);
		this.loadCommon(model);
		return "/selin/orderPros/orderPros_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(OrderPros orderPros) {
		if (orderPros != null) {
			orderProsService.save(orderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(OrderPros orderPros) {
		if (orderPros != null) {
			orderProsService.updateIgnoreNull(orderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(OrderPros orderPros) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		orderProsService.delete(orderPros);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setOrderProsService(
			@Qualifier("orderProsService") IOrderProsService orderProsService) {
		this.orderProsService = orderProsService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
