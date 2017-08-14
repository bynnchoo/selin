package com.selin.store.returnorderpros.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.returnorderpros.entity.ReturnOrderPros;
import com.selin.store.returnorderpros.entity.ReturnOrderProsVo;
import com.selin.store.returnorderpros.service.api.IReturnOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/returnorderprosAction")
public class ReturnOrderProsAction {
	private IReturnOrderProsService returnOrderProsService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/returnOrderPros/returnOrderPros_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(ReturnOrderPros returnOrderPros, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = returnOrderProsService.page(page, returnOrderPros);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/returnOrderPros/returnOrderPros_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(ReturnOrderPros returnOrderPros, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = returnOrderProsService.page(page, returnOrderPros);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		ReturnOrderPros returnOrderPros = new ReturnOrderPros();
		model.addAttribute("returnOrderPros", returnOrderPros);
		this.loadCommon(model);
		return "/selin/returnOrderPros/returnOrderPros_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(ReturnOrderPros returnOrderPros, Model model) {
		returnOrderPros = returnOrderProsService.load(returnOrderPros);
		model.addAttribute("returnOrderPros", returnOrderPros);
		this.loadCommon(model);
		return "/selin/returnOrderPros/returnOrderPros_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(ReturnOrderPros returnOrderPros, Model model) {
		returnOrderPros = returnOrderProsService.load(returnOrderPros);
		model.addAttribute("returnOrderPros", returnOrderPros);
		this.loadCommon(model);
		return "/selin/returnOrderPros/returnOrderPros_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(ReturnOrderPros returnOrderPros) {
		if (returnOrderPros != null) {
			returnOrderProsService.save(returnOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(ReturnOrderPros returnOrderPros) {
		if (returnOrderPros != null) {
			returnOrderProsService.updateIgnoreNull(returnOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(ReturnOrderPros returnOrderPros) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		returnOrderProsService.delete(returnOrderPros);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setReturnOrderProsService(
			@Qualifier("returnOrderProsService") IReturnOrderProsService returnOrderProsService) {
		this.returnOrderProsService = returnOrderProsService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
