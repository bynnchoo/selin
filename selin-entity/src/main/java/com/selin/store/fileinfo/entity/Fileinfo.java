package com.selin.store.fileinfo.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： s_fileinfo <br/>
 *         描述：s_fileinfo <br/>
 */
public class Fileinfo implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String name;// name
	protected String displayname;// displayName
	protected Long filesize;// fileSize
	protected String realpath;// realPath
	protected String webpath;// webPath
	protected String type;// type

	public Fileinfo() {
		super();
	}

	public Fileinfo(Long id) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}
	
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	
	public String getWebpath() {
		return webpath;
	}
	public void setWebpath(String webpath) {
		this.webpath = webpath;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
