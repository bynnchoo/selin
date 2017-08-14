package com.selin.store.buyorderpros.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.buyorderpros.entity.BuyOrderPros;
import com.selin.store.buyorderpros.entity.BuyOrderProsVo;
import com.selin.store.buyorderpros.service.api.IBuyOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/buyorderprosAction")
public class BuyOrderProsAction {
	private IBuyOrderProsService buyOrderProsService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/buyOrderPros/buyOrderPros_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(BuyOrderPros buyOrderPros, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = buyOrderProsService.page(page, buyOrderPros);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/buyOrderPros/buyOrderPros_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(BuyOrderPros buyOrderPros, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = buyOrderProsService.page(page, buyOrderPros);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		BuyOrderPros buyOrderPros = new BuyOrderPros();
		model.addAttribute("buyOrderPros", buyOrderPros);
		this.loadCommon(model);
		return "/selin/buyOrderPros/buyOrderPros_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(BuyOrderPros buyOrderPros, Model model) {
		buyOrderPros = buyOrderProsService.load(buyOrderPros);
		model.addAttribute("buyOrderPros", buyOrderPros);
		this.loadCommon(model);
		return "/selin/buyOrderPros/buyOrderPros_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(BuyOrderPros buyOrderPros, Model model) {
		buyOrderPros = buyOrderProsService.load(buyOrderPros);
		model.addAttribute("buyOrderPros", buyOrderPros);
		this.loadCommon(model);
		return "/selin/buyOrderPros/buyOrderPros_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(BuyOrderPros buyOrderPros) {
		if (buyOrderPros != null) {
			buyOrderProsService.save(buyOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(BuyOrderPros buyOrderPros) {
		if (buyOrderPros != null) {
			buyOrderProsService.updateIgnoreNull(buyOrderPros);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(BuyOrderPros buyOrderPros) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		buyOrderProsService.delete(buyOrderPros);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setBuyOrderProsService(
			@Qualifier("buyOrderProsService") IBuyOrderProsService buyOrderProsService) {
		this.buyOrderProsService = buyOrderProsService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
