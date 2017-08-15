package com.selin.store.warehouse.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.warehouse.entity.Warehouse;
import com.selin.store.warehouse.entity.WarehouseVo;
import com.selin.store.warehouse.service.api.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/warehouseAction")
public class WarehouseAction {
	private IWarehouseService warehouseService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/warehouse/warehouse_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Warehouse warehouse, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = warehouseService.page(page, warehouse);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/warehouse/warehouse_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Warehouse warehouse, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = warehouseService.page(page, warehouse);
		return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Warehouse warehouse = new Warehouse();
		model.addAttribute("warehouse", warehouse);
		this.loadCommon(model);
		return "/selin/warehouse/warehouse_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Warehouse warehouse, Model model) {
		warehouse = warehouseService.load(warehouse);
		model.addAttribute("warehouse", warehouse);
		this.loadCommon(model);
		return "/selin/warehouse/warehouse_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Warehouse warehouse, Model model) {
		warehouse = warehouseService.load(warehouse);
		model.addAttribute("warehouse", warehouse);
		this.loadCommon(model);
		return "/selin/warehouse/warehouse_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Warehouse warehouse) {
		if (warehouse != null) {
			warehouseService.save(warehouse);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Warehouse warehouse) {
		if (warehouse != null) {
			warehouseService.updateIgnoreNull(warehouse);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Warehouse warehouse) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		warehouseService.delete(warehouse);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setWarehouseService(
			@Qualifier("warehouseService") IWarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
