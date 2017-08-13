package com.selin.store.label.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_label <br/>
 *         描述：w_label <br/>
 */
public class LabelVo extends Label {

	private List<LabelVo> labelList;

	public LabelVo() {
		super();
	}

	public LabelVo(Long id) {
		super();
		this.id = id;
	}

	public List<LabelVo> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<LabelVo> labelList) {
		this.labelList = labelList;
	}

}
