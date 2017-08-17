package com.selin.store.customerprominimum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.customerprominimum.entity.CustomerProMinimum;
import com.selin.store.customerprominimum.entity.CustomerProMinimumVo;
import com.selin.store.customerprominimum.service.api.ICustomerProMinimumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/customerprominimumAction")
public class CustomerProMinimumAction {
	private ICustomerProMinimumService customerProMinimumService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/customerProMinimum/customerProMinimum_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(CustomerProMinimum customerProMinimum, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = customerProMinimumService.page(page, customerProMinimum);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/customerProMinimum/customerProMinimum_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(CustomerProMinimum customerProMinimum, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = customerProMinimumService.page(page, customerProMinimum);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		CustomerProMinimum customerProMinimum = new CustomerProMinimum();
		model.addAttribute("customerProMinimum", customerProMinimum);
		this.loadCommon(model);
		return "/selin/customerProMinimum/customerProMinimum_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(CustomerProMinimum customerProMinimum, Model model) {
		customerProMinimum = customerProMinimumService.load(customerProMinimum);
		model.addAttribute("customerProMinimum", customerProMinimum);
		this.loadCommon(model);
		return "/selin/customerProMinimum/customerProMinimum_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(CustomerProMinimum customerProMinimum, Model model) {
		customerProMinimum = customerProMinimumService.load(customerProMinimum);
		model.addAttribute("customerProMinimum", customerProMinimum);
		this.loadCommon(model);
		return "/selin/customerProMinimum/customerProMinimum_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(CustomerProMinimum customerProMinimum) {
		if (customerProMinimum != null) {
			customerProMinimumService.save(customerProMinimum);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(CustomerProMinimum customerProMinimum) {
		if (customerProMinimum != null) {
			customerProMinimumService.updateIgnoreNull(customerProMinimum);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(CustomerProMinimum customerProMinimum) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		customerProMinimumService.delete(customerProMinimum);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setCustomerProMinimumService(
			@Qualifier("customerProMinimumService") ICustomerProMinimumService customerProMinimumService) {
		this.customerProMinimumService = customerProMinimumService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
