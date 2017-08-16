package com.selin.store.invoice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.invoice.entity.Invoice;
import com.selin.store.invoice.entity.InvoiceVo;
import com.selin.store.invoice.service.api.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/invoiceAction")
public class InvoiceAction {
	private IInvoiceService invoiceService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/invoice/invoice_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Invoice invoice, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = invoiceService.page(page, invoice);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/invoice/invoice_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Invoice invoice, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = invoiceService.page(page, invoice);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Invoice invoice = new Invoice();
		model.addAttribute("invoice", invoice);
		this.loadCommon(model);
		return "/selin/invoice/invoice_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Invoice invoice, Model model) {
		invoice = invoiceService.load(invoice);
		model.addAttribute("invoice", invoice);
		this.loadCommon(model);
		return "/selin/invoice/invoice_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Invoice invoice, Model model) {
		invoice = invoiceService.load(invoice);
		model.addAttribute("invoice", invoice);
		this.loadCommon(model);
		return "/selin/invoice/invoice_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Invoice invoice) {
		if (invoice != null) {
			invoiceService.save(invoice);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Invoice invoice) {
		if (invoice != null) {
			invoiceService.updateIgnoreNull(invoice);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Invoice invoice) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		invoiceService.delete(invoice);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setInvoiceService(
			@Qualifier("invoiceService") IInvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
