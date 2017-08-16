package com.selin.store.fileinfo.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.fileinfo.dao.api.IFileinfoDao;
import com.selin.store.fileinfo.entity.Fileinfo;
import com.selin.store.fileinfo.entity.FileinfoVo;
import com.selin.store.fileinfo.service.api.IFileinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileinfoService implements IFileinfoService {
	private IFileinfoDao fileinfoDao;

	public Serializable save(Fileinfo fileinfo){
		return fileinfoDao.save(fileinfo);
	}

	public void delete(Fileinfo fileinfo){
		fileinfoDao.delete(fileinfo);
	}
	
	public void deleteByExample(Fileinfo fileinfo){
		fileinfoDao.deleteByExample(fileinfo);
	}

	public void update(Fileinfo fileinfo){
		fileinfoDao.update(fileinfo);
	}
	
	public void updateIgnoreNull(Fileinfo fileinfo){
		fileinfoDao.updateIgnoreNull(fileinfo);
	}
		
	public void updateByExample(Fileinfo fileinfo){
		fileinfoDao.update("updateByExampleFileinfo", fileinfo);
	}

	public FileinfoVo load(Fileinfo fileinfo){
		return (FileinfoVo)fileinfoDao.reload(fileinfo);
	}
	
	public FileinfoVo selectForObject(Fileinfo fileinfo){
		return (FileinfoVo)fileinfoDao.selectForObject("selectFileinfo",fileinfo);
	}
	
	public List<FileinfoVo> selectForList(Fileinfo fileinfo){
		return (List<FileinfoVo>)fileinfoDao.selectForList("selectFileinfo",fileinfo);
	}
	
	public Page page(Page page, Fileinfo fileinfo) {
		return fileinfoDao.page(page, fileinfo);
	}

	@Autowired
	public void setIFileinfoDao(
			@Qualifier("fileinfoDao") IFileinfoDao  fileinfoDao) {
		this.fileinfoDao = fileinfoDao;
	}
	

}
