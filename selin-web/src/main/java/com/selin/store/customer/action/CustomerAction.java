package com.selin.store.customer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.customer.entity.Customer;
import com.selin.store.customer.entity.CustomerVo;
import com.selin.store.customer.service.api.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/customerAction")
public class CustomerAction {
	private ICustomerService customerService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/customer/customer_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Customer customer, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = customerService.page(page, customer);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/customer/customer_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Customer customer, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = customerService.page(page, customer);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		this.loadCommon(model);
		return "/selin/customer/customer_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Customer customer, Model model) {
		customer = customerService.load(customer);
		model.addAttribute("customer", customer);
		this.loadCommon(model);
		return "/selin/customer/customer_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Customer customer, Model model) {
		customer = customerService.load(customer);
		model.addAttribute("customer", customer);
		this.loadCommon(model);
		return "/selin/customer/customer_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Customer customer) {
		if (customer != null) {
			customerService.save(customer);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Customer customer) {
		if (customer != null) {
			customerService.updateIgnoreNull(customer);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Customer customer) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		customerService.delete(customer);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setCustomerService(
			@Qualifier("customerService") ICustomerService customerService) {
		this.customerService = customerService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
