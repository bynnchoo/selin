package com.selin.store.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.selin.core.exception.SelinException;
import com.selin.store.labelrel.service.api.IProductLabelRelService;
import com.selin.store.norms.service.api.IProductNormsService;
import com.selin.store.product.entity.ProductDto;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.dictionary.entity.Dictionary;
import org.roof.web.dictionary.service.api.IDictionaryService;
import com.selin.store.product.entity.Product;
import com.selin.store.product.entity.ProductVo;
import com.selin.store.product.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("selin/productAction")
public class ProductAction {
    private IProductService productService;
    private IDictionaryService dictionaryService;

    // 加载页面的通用数据
    private void loadCommon(Model model) {
        List<Dictionary> dicList = dictionaryService.findByType("TEST");
        model.addAttribute("dicList", dicList);
    }

    @RequestMapping("/index")
    public String index() {
        return "/selin/product/product_index.jsp";
    }

	/*
    @RequestMapping("/list")
	public String list(Product product, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = productService.page(page, product);
		model.addAttribute("page", page);
		model.addAllAttributes(PageUtils.createPagePar(page));
		this.loadCommon(model);
		return "/selin/product/product_list.jsp";
	}
	*/

    /*@RequestMapping("/list")
    public @ResponseBody Result list(Product product, HttpServletRequest request, Model model) {
		Page page = PageUtils.createPage(request);
		page = productService.page(page, product);
		return new Result(Result.SUCCESS,page);
	}*/

    @RequestMapping("/page")
    public @ResponseBody
    Result productNomrsPage(Product product, HttpServletRequest request, Model model) {
        Page page = PageUtils.createPage(request);
        page = productService.productNomrsPage(page, product);
        return new Result(Result.SUCCESS, page);
    }

    @RequestMapping("/list")
    public @ResponseBody
    Result productNomrsList(Product product, HttpServletRequest request, Model model) {
        List<ProductVo> productVos = productService.selectProductNormsList(product);
        return new Result(Result.SUCCESS, productVos);
    }

    @RequestMapping("/stock")
    public @ResponseBody
    Result productNomrsStockPage(Product product, HttpServletRequest request, Model model) {
        Page page = PageUtils.createPage(request);
        page = productService.productNomrsStockPage(page, product);

        return new Result(Result.SUCCESS, page);
    }

    @RequestMapping("/create")
    public @ResponseBody
    Result create(ProductDto product) {
        if (product != null) {
            productService.create(product);
            return new Result("保存成功!");
        } else {
            return new Result("数据传输失败!");
        }
    }



    @RequestMapping("/create_page")
    public String create_page(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        this.loadCommon(model);
        return "/selin/product/product_create.jsp";
    }

    @RequestMapping("/update_page")
    public String update_page(Product product, Model model) {
        product = productService.load(product);
        model.addAttribute("product", product);
        this.loadCommon(model);
        return "/selin/product/product_update.jsp";
    }

    @RequestMapping("/detail_page")
    public String detail_page(Product product, Model model) {
        product = productService.load(product);
        model.addAttribute("product", product);
        this.loadCommon(model);
        return "/selin/product/product_detail.jsp";
    }

    /*@RequestMapping("/create")
    public @ResponseBody
    Result create(Product product) {
        if (product != null) {
            productService.save(product);
            return new Result("保存成功!");
        } else {
            return new Result("数据传输失败!");
        }
    }*/

    @RequestMapping("/update")
    public @ResponseBody
    Result update(Product product) {
        if (product != null) {
            productService.updateIgnoreNull(product);
            return new Result("保存成功!");
        } else {
            return new Result("数据传输失败!");
        }
    }

    @RequestMapping("/delete")
    public @ResponseBody
    Result delete(Product product) {
        // TODO 有些关键数据是不能物理删除的，需要改为逻辑删除
        productService.delete(product);
        return new Result("删除成功!");
    }

    @Autowired(required = true)
    public void setProductService(
            @Qualifier("productService") IProductService productService) {
        this.productService = productService;
    }

    @Autowired(required = true)
    public void setDictionaryService(@Qualifier("dictionaryService") IDictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
}
