package com.selin.store.dispatchorderpros.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.dispatchorderpros.entity.DispatchOrderPros;
import com.selin.store.dispatchorderpros.entity.DispatchOrderProsVo;
import com.selin.store.dispatchorderpros.service.api.IDispatchOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/dispatchorderprosAction")
public class DispatchOrderProsAction {
	private IDispatchOrderProsService dispatchOrderProsService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/dispatchOrderPros/dispatchOrderPros_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(DispatchOrderPros dispatchOrderPros, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = dispatchOrderProsService.page(page, dispatchOrderPros);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/dispatchOrderPros/dispatchOrderPros_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(DispatchOrderPros dispatchOrderPros, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = dispatchOrderProsService.page(page, dispatchOrderPros);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		DispatchOrderPros dispatchOrderPros = new DispatchOrderPros();
		model.addAttribute("dispatchOrderPros", dispatchOrderPros);
		this.loadCommon(model);
		return "/selin/dispatchOrderPros/dispatchOrderPros_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(DispatchOrderPros dispatchOrderPros, Model model) {
		dispatchOrderPros = dispatchOrderProsService.load(dispatchOrderPros);
		model.addAttribute("dispatchOrderPros", dispatchOrderPros);
		this.loadCommon(model);
		return "/selin/dispatchOrderPros/dispatchOrderPros_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(DispatchOrderPros dispatchOrderPros, Model model) {
		dispatchOrderPros = dispatchOrderProsService.load(dispatchOrderPros);
		model.addAttribute("dispatchOrderPros", dispatchOrderPros);
		this.loadCommon(model);
		return "/selin/dispatchOrderPros/dispatchOrderPros_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(DispatchOrderPros dispatchOrderPros) {
		if (dispatchOrderPros != null) {
			dispatchOrderProsService.save(dispatchOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(DispatchOrderPros dispatchOrderPros) {
		if (dispatchOrderPros != null) {
			dispatchOrderProsService.updateIgnoreNull(dispatchOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(DispatchOrderPros dispatchOrderPros) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		dispatchOrderProsService.delete(dispatchOrderPros);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setDispatchOrderProsService(
			@Qualifier("dispatchOrderProsService") IDispatchOrderProsService dispatchOrderProsService) {
		this.dispatchOrderProsService = dispatchOrderProsService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
