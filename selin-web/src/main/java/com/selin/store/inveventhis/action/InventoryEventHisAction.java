package com.selin.store.inveventhis.action;

import java.util.Date;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpServletRequest;

import com.selin.core.exception.SelinException;
import com.selin.store.invevent.entity.InventoryEventEnum;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.inveventhis.entity.InventoryEventHis;
import com.selin.store.inveventhis.entity.InventoryEventHisVo;
import com.selin.store.inveventhis.service.api.IInventoryEventHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/inveventhisAction")
public class InventoryEventHisAction {
	private IInventoryEventHisService inventoryEventHisService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/inventoryEventHis/inventoryEventHis_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(InventoryEventHis inventoryEventHis, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = inventoryEventHisService.page(page, inventoryEventHis);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/inventoryEventHis/inventoryEventHis_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(InventoryEventHisVo inventoryEventHis, HttpServletRequest request, Model model) {
	    if (inventoryEventHis.getEvent_type() == null){
	    	return new Result(Result.FAIL, "事件类型不能为空");
		}
    	Page page = PageUtils.createPage(request);
	    page = inventoryEventHisService.page(page, inventoryEventHis);
	    return new Result(Result.SUCCESS, page);
	}

	@RequestMapping("/detail")
	public @ResponseBody Result detail(InventoryEventHisVo inventoryEventHis, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = inventoryEventHisService.detailPage(page, inventoryEventHis);
		return new Result(Result.SUCCESS, page);
	}


	@RequestMapping("/code")
	public @ResponseBody Result code(String type, HttpServletRequest request, Model model) {
		InventoryEventEnum eventenum = null;
    	try {
			eventenum = InventoryEventEnum.valueOf(type);
		}catch (Exception e){
			throw  new SelinException("类型不对");
		}
		String code = inventoryEventHisService.createEventCode(eventenum,new Date());
		return new Result(Result.SUCCESS, "",code);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		InventoryEventHis inventoryEventHis = new InventoryEventHis();
		model.addAttribute("inventoryEventHis", inventoryEventHis);
		this.loadCommon(model);
		return "/selin/inventoryEventHis/inventoryEventHis_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(InventoryEventHis inventoryEventHis, Model model) {
		inventoryEventHis = inventoryEventHisService.load(inventoryEventHis);
		model.addAttribute("inventoryEventHis", inventoryEventHis);
		this.loadCommon(model);
		return "/selin/inventoryEventHis/inventoryEventHis_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(InventoryEventHis inventoryEventHis, Model model) {
		inventoryEventHis = inventoryEventHisService.load(inventoryEventHis);
		model.addAttribute("inventoryEventHis", inventoryEventHis);
		this.loadCommon(model);
		return "/selin/inventoryEventHis/inventoryEventHis_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(InventoryEventHis inventoryEventHis) {
		if (inventoryEventHis != null) {
			inventoryEventHisService.save(inventoryEventHis);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(InventoryEventHis inventoryEventHis) {
		if (inventoryEventHis != null) {
			inventoryEventHisService.updateIgnoreNull(inventoryEventHis);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(InventoryEventHis inventoryEventHis) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		inventoryEventHisService.delete(inventoryEventHis);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setInventoryEventHisService(
			@Qualifier("inventoryEventHisService") IInventoryEventHisService inventoryEventHisService) {
		this.inventoryEventHisService = inventoryEventHisService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
