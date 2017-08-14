package com.selin.store.returnorder.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.returnorder.entity.ReturnOrder;
import com.selin.store.returnorder.entity.ReturnOrderVo;
import com.selin.store.returnorder.service.api.IReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/returnorderAction")
public class ReturnOrderAction {
	private IReturnOrderService returnOrderService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/returnOrder/returnOrder_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(ReturnOrder returnOrder, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = returnOrderService.page(page, returnOrder);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/returnOrder/returnOrder_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(ReturnOrder returnOrder, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = returnOrderService.page(page, returnOrder);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		ReturnOrder returnOrder = new ReturnOrder();
		model.addAttribute("returnOrder", returnOrder);
		this.loadCommon(model);
		return "/selin/returnOrder/returnOrder_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(ReturnOrder returnOrder, Model model) {
		returnOrder = returnOrderService.load(returnOrder);
		model.addAttribute("returnOrder", returnOrder);
		this.loadCommon(model);
		return "/selin/returnOrder/returnOrder_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(ReturnOrder returnOrder, Model model) {
		returnOrder = returnOrderService.load(returnOrder);
		model.addAttribute("returnOrder", returnOrder);
		this.loadCommon(model);
		return "/selin/returnOrder/returnOrder_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(ReturnOrder returnOrder) {
		if (returnOrder != null) {
			returnOrderService.save(returnOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(ReturnOrder returnOrder) {
		if (returnOrder != null) {
			returnOrderService.updateIgnoreNull(returnOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(ReturnOrder returnOrder) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		returnOrderService.delete(returnOrder);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setReturnOrderService(
			@Qualifier("returnOrderService") IReturnOrderService returnOrderService) {
		this.returnOrderService = returnOrderService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
