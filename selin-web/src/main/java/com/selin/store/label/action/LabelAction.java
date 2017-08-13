package com.selin.store.label.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.label.entity.Label;
import com.selin.store.label.entity.LabelVo;
import com.selin.store.label.service.api.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/labelAction")
public class LabelAction {
	private ILabelService labelService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/label/label_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Label label, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = labelService.page(page, label);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/label/label_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Label label, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = labelService.page(page, label);
		return new Result(Result.SUCCESS,page);
    }


	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Label label = new Label();
		model.addAttribute("label", label);
		this.loadCommon(model);
		return "/selin/label/label_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Label label, Model model) {
		label = labelService.load(label);
		model.addAttribute("label", label);
		this.loadCommon(model);
		return "/selin/label/label_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Label label, Model model) {
		label = labelService.load(label);
		model.addAttribute("label", label);
		this.loadCommon(model);
		return "/selin/label/label_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Label label) {
		if (label != null) {
			labelService.save(label);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Label label) {
		if (label != null) {
			labelService.updateIgnoreNull(label);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Label label) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		labelService.delete(label);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setLabelService(
			@Qualifier("labelService") ILabelService labelService) {
		this.labelService = labelService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
