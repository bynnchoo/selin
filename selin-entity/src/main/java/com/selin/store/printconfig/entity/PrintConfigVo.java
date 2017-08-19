package com.selin.store.printconfig.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_print_config <br/>
 *         描述：用户监听哪些频道消息 <br/>
 */
public class PrintConfigVo extends PrintConfig {

	private List<PrintConfigVo> printConfigList;

	public PrintConfigVo() {
		super();
	}

	public PrintConfigVo(Long id) {
		super();
		this.id = id;
	}

	public List<PrintConfigVo> getPrintConfigList() {
		return printConfigList;
	}

	public void setPrintConfigList(List<PrintConfigVo> printConfigList) {
		this.printConfigList = printConfigList;
	}

}
