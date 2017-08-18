package com.selin.store.invevent.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.selin.core.exception.SelinException;
import com.selin.store.inventory.entity.Inventory;
import com.selin.store.invevent.entity.InventoryEventEnum;
import org.apache.commons.lang3.StringUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.invevent.entity.InventoryEvent;
import com.selin.store.invevent.entity.InventoryEventVo;
import com.selin.store.invevent.service.api.IInventoryEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/inveventAction")
public class InventoryEventAction {
	private IInventoryEventService inventoryEventService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/inventoryEvent/inventoryEvent_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(InventoryEvent inventoryEvent, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = inventoryEventService.page(page, inventoryEvent);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/inventoryEvent/inventoryEvent_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(InventoryEvent inventoryEvent, HttpServletRequest request, Model model) {
	    Page page = PageUtils.createPage(request);
	    page = inventoryEventService.page(page, inventoryEvent);
	    return new Result(Result.SUCCESS, page);
	}

	@RequestMapping("/inStock")
	public @ResponseBody Result inStock (InventoryEventVo vo, HttpServletRequest request, Model model) {
		String type = vo.getEvent_type();
		try {
			InventoryEventEnum.valueOf(type);
		}catch (Exception e){
			throw new SelinException("入库类型不对");
		}
		if (StringUtils.isBlank(vo.getEvent_code())){
			throw new SelinException("编码不能为空");
		}
		inventoryEventService.inStock(vo);
		return new Result(Result.SUCCESS);
	}

	@RequestMapping("/outStock")
	public @ResponseBody Result outStock (InventoryEventVo vo, HttpServletRequest request, Model model) {
		String type = vo.getEvent_type();
		try {
			InventoryEventEnum.valueOf(type);
		}catch (Exception e){
			throw new SelinException("出库类型不对");
		}
		if (StringUtils.isBlank(vo.getEvent_code())){
			throw new SelinException("编码不能为空");
		}
		inventoryEventService.inStock(vo);
		return new Result(Result.SUCCESS);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		InventoryEvent inventoryEvent = new InventoryEvent();
		model.addAttribute("inventoryEvent", inventoryEvent);
		this.loadCommon(model);
		return "/selin/inventoryEvent/inventoryEvent_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(InventoryEvent inventoryEvent, Model model) {
		inventoryEvent = inventoryEventService.load(inventoryEvent);
		model.addAttribute("inventoryEvent", inventoryEvent);
		this.loadCommon(model);
		return "/selin/inventoryEvent/inventoryEvent_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(InventoryEvent inventoryEvent, Model model) {
		inventoryEvent = inventoryEventService.load(inventoryEvent);
		model.addAttribute("inventoryEvent", inventoryEvent);
		this.loadCommon(model);
		return "/selin/inventoryEvent/inventoryEvent_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(InventoryEvent inventoryEvent) {
		if (inventoryEvent != null) {
			inventoryEventService.save(inventoryEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(InventoryEvent inventoryEvent) {
		if (inventoryEvent != null) {
			inventoryEventService.updateIgnoreNull(inventoryEvent);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(InventoryEvent inventoryEvent) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		inventoryEventService.delete(inventoryEvent);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setInventoryEventService(
			@Qualifier("inventoryEventService") IInventoryEventService inventoryEventService) {
		this.inventoryEventService = inventoryEventService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
