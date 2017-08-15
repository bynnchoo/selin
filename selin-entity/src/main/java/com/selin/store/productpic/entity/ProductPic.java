package com.selin.store.productpic.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_pic <br/>
 *         描述：商品图片 <br/>
 */
public class ProductPic implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long product_id;// 商品id
	protected String pic_name;// 图片名称

	public ProductPic() {
		super();
	}

	public ProductPic(Long id) {
		super();
		this.id = id;
	}
	
	@Id// 主键
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	public String getPic_name() {
		return pic_name;
	}
	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}
}
