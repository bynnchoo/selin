package com.selin.store.area.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.area.entity.Area;
import com.selin.store.area.entity.AreaVo;
import com.selin.store.area.service.api.IAreaService;
import com.selin.store.category.entity.Category;
import com.selin.store.category.entity.CategoryVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/areaAction")
public class AreaAction {
	private IAreaService areaService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model) {
		List<Dictionary> dicList = dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/tree")
	public @ResponseBody Result tree(Area area, HttpServletRequest request, Model model) {
		AreaVo vo = areaService.tree();
		return new Result(Result.SUCCESS, vo);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/area/area_index.jsp";
	}

	/*
	 * @RequestMapping("/list") public String list(Area area, HttpServletRequest
	 * request, Model model) { Page page = PageUtils.createPage(request); page =
	 * areaService.page(page, area); model.addAttribute("page", page);
	 * model.addAllAttributes(PageUtils.createPagePar(page));
	 * this.loadCommon(model); return "/selin/area/area_list.jsp"; }
	 */

	@RequestMapping("/list")
	public @ResponseBody Result list(Area area, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = areaService.page(page, area);
		return new Result(Result.SUCCESS, page);
	}

	@RequestMapping("/create_page")
	public String create_page(Model model) {
		Area area = new Area();
		model.addAttribute("area", area);
		this.loadCommon(model);
		return "/selin/area/area_create.jsp";
	}

	@RequestMapping("/update_page")
	public String update_page(Area area, Model model) {
		area = areaService.load(area);
		model.addAttribute("area", area);
		this.loadCommon(model);
		return "/selin/area/area_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(Area area, Model model) {
		area = areaService.load(area);
		model.addAttribute("area", area);
		this.loadCommon(model);
		return "/selin/area/area_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(Area area) {
		if (area != null) {
			areaService.save(area);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}

	@RequestMapping("/update")
	public @ResponseBody Result update(Area area) {
		if (area != null) {
			areaService.updateIgnoreNull(area);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}

	@RequestMapping("/delete")
	public @ResponseBody Result delete(Area area) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		areaService.delete(area);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setAreaService(@Qualifier("areaService") IAreaService areaService) {
		this.areaService = areaService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
