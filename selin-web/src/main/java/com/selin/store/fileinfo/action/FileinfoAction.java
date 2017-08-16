package com.selin.store.fileinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.fileinfo.entity.Fileinfo;
import com.selin.store.fileinfo.entity.FileinfoVo;
import com.selin.store.fileinfo.service.api.IFileinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/fileinfoAction")
public class FileinfoAction {
	private IFileinfoService fileinfoService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/fileinfo/fileinfo_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(Fileinfo fileinfo, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = fileinfoService.page(page, fileinfo);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/fileinfo/fileinfo_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(Fileinfo fileinfo, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = fileinfoService.page(page, fileinfo);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Fileinfo fileinfo = new Fileinfo();
		model.addAttribute("fileinfo", fileinfo);
		this.loadCommon(model);
		return "/selin/fileinfo/fileinfo_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(Fileinfo fileinfo, Model model) {
		fileinfo = fileinfoService.load(fileinfo);
		model.addAttribute("fileinfo", fileinfo);
		this.loadCommon(model);
		return "/selin/fileinfo/fileinfo_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Fileinfo fileinfo, Model model) {
		fileinfo = fileinfoService.load(fileinfo);
		model.addAttribute("fileinfo", fileinfo);
		this.loadCommon(model);
		return "/selin/fileinfo/fileinfo_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Fileinfo fileinfo) {
		if (fileinfo != null) {
			fileinfoService.save(fileinfo);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(Fileinfo fileinfo) {
		if (fileinfo != null) {
			fileinfoService.updateIgnoreNull(fileinfo);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(Fileinfo fileinfo) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		fileinfoService.delete(fileinfo);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setFileinfoService(
			@Qualifier("fileinfoService") IFileinfoService fileinfoService) {
		this.fileinfoService = fileinfoService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
