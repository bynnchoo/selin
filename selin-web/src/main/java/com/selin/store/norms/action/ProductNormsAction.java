package com.selin.store.norms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.norms.entity.ProductNorms;
import com.selin.store.norms.entity.ProductNormsVo;
import com.selin.store.norms.service.api.IProductNormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/normsAction")
public class ProductNormsAction {
	private IProductNormsService productNormsService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/productNorms/productNorms_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(ProductNorms productNorms, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = productNormsService.page(page, productNorms);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/productNorms/productNorms_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(ProductNorms productNorms, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = productNormsService.page(page, productNorms);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		ProductNorms productNorms = new ProductNorms();
		model.addAttribute("productNorms", productNorms);
		this.loadCommon(model);
		return "/selin/productNorms/productNorms_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(ProductNorms productNorms, Model model) {
		productNorms = productNormsService.load(productNorms);
		model.addAttribute("productNorms", productNorms);
		this.loadCommon(model);
		return "/selin/productNorms/productNorms_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(ProductNorms productNorms, Model model) {
		productNorms = productNormsService.load(productNorms);
		model.addAttribute("productNorms", productNorms);
		this.loadCommon(model);
		return "/selin/productNorms/productNorms_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(ProductNorms productNorms) {
		if (productNorms != null) {
			productNormsService.save(productNorms);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(ProductNorms productNorms) {
		if (productNorms != null) {
			productNormsService.updateIgnoreNull(productNorms);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(ProductNorms productNorms) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		productNormsService.delete(productNorms);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setProductNormsService(
			@Qualifier("productNormsService") IProductNormsService productNormsService) {
		this.productNormsService = productNormsService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
