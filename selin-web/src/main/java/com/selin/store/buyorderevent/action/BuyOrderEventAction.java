package com.selin.store.buyorderevent.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.buyorderevent.entity.BuyOrderEvent;
import com.selin.store.buyorderevent.entity.BuyOrderEventVo;
import com.selin.store.buyorderevent.service.api.IBuyOrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/buyordereventAction")
public class BuyOrderEventAction {
	private IBuyOrderEventService buyOrderEventService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/buyOrderEvent/buyOrderEvent_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(BuyOrderEvent buyOrderEvent, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = buyOrderEventService.page(page, buyOrderEvent);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/buyOrderEvent/buyOrderEvent_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(BuyOrderEvent buyOrderEvent, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = buyOrderEventService.page(page, buyOrderEvent);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		BuyOrderEvent buyOrderEvent = new BuyOrderEvent();
		model.addAttribute("buyOrderEvent", buyOrderEvent);
		this.loadCommon(model);
		return "/selin/buyOrderEvent/buyOrderEvent_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(BuyOrderEvent buyOrderEvent, Model model) {
		buyOrderEvent = buyOrderEventService.load(buyOrderEvent);
		model.addAttribute("buyOrderEvent", buyOrderEvent);
		this.loadCommon(model);
		return "/selin/buyOrderEvent/buyOrderEvent_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(BuyOrderEvent buyOrderEvent, Model model) {
		buyOrderEvent = buyOrderEventService.load(buyOrderEvent);
		model.addAttribute("buyOrderEvent", buyOrderEvent);
		this.loadCommon(model);
		return "/selin/buyOrderEvent/buyOrderEvent_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(BuyOrderEvent buyOrderEvent) {
		if (buyOrderEvent != null) {
			buyOrderEventService.save(buyOrderEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(BuyOrderEvent buyOrderEvent) {
		if (buyOrderEvent != null) {
			buyOrderEventService.updateIgnoreNull(buyOrderEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(BuyOrderEvent buyOrderEvent) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		buyOrderEventService.delete(buyOrderEvent);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setBuyOrderEventService(
			@Qualifier("buyOrderEventService") IBuyOrderEventService buyOrderEventService) {
		this.buyOrderEventService = buyOrderEventService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
