package com.selin.store.dispatchorder.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.dispatchorder.entity.DispatchOrder;
import com.selin.store.dispatchorder.entity.DispatchOrderVo;
import com.selin.store.dispatchorder.service.api.IDispatchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/dispatchorderAction")
public class DispatchOrderAction {
	private IDispatchOrderService dispatchOrderService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/dispatchOrder/dispatchOrder_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(DispatchOrder dispatchOrder, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = dispatchOrderService.page(page, dispatchOrder);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/dispatchOrder/dispatchOrder_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(DispatchOrder dispatchOrder, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = dispatchOrderService.page(page, dispatchOrder);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		DispatchOrder dispatchOrder = new DispatchOrder();
		model.addAttribute("dispatchOrder", dispatchOrder);
		this.loadCommon(model);
		return "/selin/dispatchOrder/dispatchOrder_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(DispatchOrder dispatchOrder, Model model) {
		dispatchOrder = dispatchOrderService.load(dispatchOrder);
		model.addAttribute("dispatchOrder", dispatchOrder);
		this.loadCommon(model);
		return "/selin/dispatchOrder/dispatchOrder_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(DispatchOrder dispatchOrder, Model model) {
		dispatchOrder = dispatchOrderService.load(dispatchOrder);
		model.addAttribute("dispatchOrder", dispatchOrder);
		this.loadCommon(model);
		return "/selin/dispatchOrder/dispatchOrder_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(DispatchOrder dispatchOrder) {
		if (dispatchOrder != null) {
			dispatchOrderService.save(dispatchOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(DispatchOrder dispatchOrder) {
		if (dispatchOrder != null) {
			dispatchOrderService.updateIgnoreNull(dispatchOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(DispatchOrder dispatchOrder) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		dispatchOrderService.delete(dispatchOrder);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setDispatchOrderService(
			@Qualifier("dispatchOrderService") IDispatchOrderService dispatchOrderService) {
		this.dispatchOrderService = dispatchOrderService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
