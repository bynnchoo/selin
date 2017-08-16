package com.selin.store.fileinfo.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： s_fileinfo <br/>
 *         描述：s_fileinfo <br/>
 */
public class FileinfoVo extends Fileinfo {

	private List<FileinfoVo> fileinfoList;

	public FileinfoVo() {
		super();
	}

	public FileinfoVo(Long id) {
		super();
		this.id = id;
	}

	public List<FileinfoVo> getFileinfoList() {
		return fileinfoList;
	}

	public void setFileinfoList(List<FileinfoVo> fileinfoList) {
		this.fileinfoList = fileinfoList;
	}

}
