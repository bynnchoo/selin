package com.selin.store.supplier.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.supplier.entity.Supplier;
import com.selin.store.supplier.entity.SupplierVo;
import com.selin.store.supplier.service.api.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/supplierAction")
public class SupplierAction {
	private ISupplierService supplierService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/supplier/supplier_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Supplier supplier, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = supplierService.page(page, supplier);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/supplier/supplier_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Supplier supplier, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = supplierService.page(page, supplier);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		this.loadCommon(model);
		return "/selin/supplier/supplier_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Supplier supplier, Model model) {
		supplier = supplierService.load(supplier);
		model.addAttribute("supplier", supplier);
		this.loadCommon(model);
		return "/selin/supplier/supplier_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Supplier supplier, Model model) {
		supplier = supplierService.load(supplier);
		model.addAttribute("supplier", supplier);
		this.loadCommon(model);
		return "/selin/supplier/supplier_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Supplier supplier) {
		if (supplier != null) {
			supplierService.save(supplier);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Supplier supplier) {
		if (supplier != null) {
			supplierService.updateIgnoreNull(supplier);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Supplier supplier) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		supplierService.delete(supplier);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setSupplierService(
			@Qualifier("supplierService") ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
