package com.selin.store.buyorder.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.buyorder.entity.BuyOrder;
import com.selin.store.buyorder.entity.BuyOrderVo;
import com.selin.store.buyorder.service.api.IBuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/buyorderAction")
public class BuyOrderAction {
	private IBuyOrderService buyOrderService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/buyOrder/buyOrder_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(BuyOrder buyOrder, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = buyOrderService.page(page, buyOrder);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/buyOrder/buyOrder_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(BuyOrder buyOrder, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = buyOrderService.page(page, buyOrder);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		BuyOrder buyOrder = new BuyOrder();
		model.addAttribute("buyOrder", buyOrder);
		this.loadCommon(model);
		return "/selin/buyOrder/buyOrder_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(BuyOrder buyOrder, Model model) {
		buyOrder = buyOrderService.load(buyOrder);
		model.addAttribute("buyOrder", buyOrder);
		this.loadCommon(model);
		return "/selin/buyOrder/buyOrder_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(BuyOrder buyOrder, Model model) {
		buyOrder = buyOrderService.load(buyOrder);
		model.addAttribute("buyOrder", buyOrder);
		this.loadCommon(model);
		return "/selin/buyOrder/buyOrder_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(BuyOrder buyOrder) {
		if (buyOrder != null) {
			buyOrderService.save(buyOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(BuyOrder buyOrder) {
		if (buyOrder != null) {
			buyOrderService.updateIgnoreNull(buyOrder);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(BuyOrder buyOrder) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		buyOrderService.delete(buyOrder);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setBuyOrderService(
			@Qualifier("buyOrderService") IBuyOrderService buyOrderService) {
		this.buyOrderService = buyOrderService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
