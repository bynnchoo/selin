package com.selin.store.printconfig.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.printconfig.entity.PrintConfig;
import com.selin.store.printconfig.entity.PrintConfigVo;
import com.selin.store.printconfig.service.api.IPrintConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/printconfigAction")
public class PrintConfigAction {
	private IPrintConfigService printConfigService;
	private IDictionaryService dictionaryService;

	// 加载页面的通用数据
	private void loadCommon(Model model){
		List<Dictionary> dicList =  dictionaryService.findByType("TEST");
		model.addAttribute("dicList", dicList);
	}

	@RequestMapping("/index")
	public String index() {
		return "/selin/printConfig/printConfig_index.jsp";
	}

	/*
	@RequestMapping("/list")
	public String list(PrintConfig printConfig, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = printConfigService.page(page, printConfig);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/printConfig/printConfig_list.jsp";
	}
	*/

    @RequestMapping("/list")
    public @ResponseBody Result list(PrintConfig printConfig, HttpServletRequest request, Model model) {
    Page page = PageUtils.createPage(request);
    page = printConfigService.page(page, printConfig);
    return new Result(Result.SUCCESS,page);
	}
	
	
	@RequestMapping("/create_page")
	public String create_page(Model model) {
		PrintConfig printConfig = new PrintConfig();
		model.addAttribute("printConfig", printConfig);
		this.loadCommon(model);
		return "/selin/printConfig/printConfig_create.jsp";
	}
	
	@RequestMapping("/update_page")
	public String update_page(PrintConfig printConfig, Model model) {
		printConfig = printConfigService.load(printConfig);
		model.addAttribute("printConfig", printConfig);
		this.loadCommon(model);
		return "/selin/printConfig/printConfig_update.jsp";
	}

	@RequestMapping("/detail_page")
	public String detail_page(PrintConfig printConfig, Model model) {
		printConfig = printConfigService.load(printConfig);
		model.addAttribute("printConfig", printConfig);
		this.loadCommon(model);
		return "/selin/printConfig/printConfig_detail.jsp";
	}

	@RequestMapping("/create")
	public @ResponseBody Result create(PrintConfig printConfig) {
		if (printConfig != null) {
			printConfigService.save(printConfig);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/update")
	public @ResponseBody Result update(PrintConfig printConfig) {
		if (printConfig != null) {
			printConfigService.updateIgnoreNull(printConfig);
			return new Result("保存成功!");
		} else {
			return new Result("数据传输失败!");
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Result delete(PrintConfig printConfig) {
		// TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
		printConfigService.delete(printConfig);
		return new Result("删除成功!");
	}

	@Autowired(required = true)
	public void setPrintConfigService(
			@Qualifier("printConfigService") IPrintConfigService printConfigService) {
		this.printConfigService = printConfigService;
	}

	@Autowired(required = true)
	public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}
