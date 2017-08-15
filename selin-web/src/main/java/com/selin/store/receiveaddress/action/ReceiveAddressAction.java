package com.selin.store.receiveaddress.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.receiveaddress.entity.ReceiveAddress;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.receiveaddress.service.api.IReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/receiveaddressAction")
public class ReceiveAddressAction {
	private IReceiveAddressService receiveAddressService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/receiveAddress/receiveAddress_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(ReceiveAddress receiveAddress, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = receiveAddressService.page(page, receiveAddress);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/receiveAddress/receiveAddress_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(ReceiveAddress receiveAddress, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = receiveAddressService.page(page, receiveAddress);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		ReceiveAddress receiveAddress = new ReceiveAddress();
		model.addAttribute("receiveAddress", receiveAddress);
		this.loadCommon(model);
		return "/selin/receiveAddress/receiveAddress_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(ReceiveAddress receiveAddress, Model model) {
		receiveAddress = receiveAddressService.load(receiveAddress);
		model.addAttribute("receiveAddress", receiveAddress);
		this.loadCommon(model);
		return "/selin/receiveAddress/receiveAddress_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(ReceiveAddress receiveAddress, Model model) {
		receiveAddress = receiveAddressService.load(receiveAddress);
		model.addAttribute("receiveAddress", receiveAddress);
		this.loadCommon(model);
		return "/selin/receiveAddress/receiveAddress_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(ReceiveAddress receiveAddress) {
		if (receiveAddress != null) {
			receiveAddressService.save(receiveAddress);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(ReceiveAddress receiveAddress) {
		if (receiveAddress != null) {
			receiveAddressService.updateIgnoreNull(receiveAddress);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(ReceiveAddress receiveAddress) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		receiveAddressService.delete(receiveAddress);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setReceiveAddressService(
			@Qualifier("receiveAddressService") IReceiveAddressService receiveAddressService) {
		this.receiveAddressService = receiveAddressService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
