package com.selin.store.inventory.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.inventory.entity.Inventory;
import com.selin.store.inventory.entity.InventoryVo;
import com.selin.store.inventory.service.api.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/inventoryAction")
public class InventoryAction {
	private IInventoryService inventoryService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/inventory/inventory_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Inventory inventory, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = inventoryService.page(page, inventory);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/inventory/inventory_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Inventory inventory, HttpServletRequest request, Model model) {
	    Page page = PageUtils.createPage(request);
	    page = inventoryService.page(page, inventory);
	    return new Result(Result.SUCCESS, page);
	}




	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Inventory inventory = new Inventory();
		model.addAttribute("inventory", inventory);
		this.loadCommon(model);
		return "/selin/inventory/inventory_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Inventory inventory, Model model) {
		inventory = inventoryService.load(inventory);
		model.addAttribute("inventory", inventory);
		this.loadCommon(model);
		return "/selin/inventory/inventory_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Inventory inventory, Model model) {
		inventory = inventoryService.load(inventory);
		model.addAttribute("inventory", inventory);
		this.loadCommon(model);
		return "/selin/inventory/inventory_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Inventory inventory) {
		if (inventory != null) {
			inventoryService.save(inventory);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Inventory inventory) {
		if (inventory != null) {
			inventoryService.updateIgnoreNull(inventory);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Inventory inventory) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		inventoryService.delete(inventory);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setInventoryService(
			@Qualifier("inventoryService") IInventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
