package com.selin.store.label.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.label.dao.api.ILabelDao;
import com.selin.store.label.entity.Label;
import com.selin.store.label.entity.LabelVo;
import com.selin.store.label.service.api.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LabelService implements ILabelService {
	private ILabelDao labelDao;

	public Serializable save(Label label){
		return labelDao.save(label);
	}

	public void delete(Label label){
		labelDao.delete(label);
	}
	
	public void deleteByExample(Label label){
		labelDao.deleteByExample(label);
	}

	public void update(Label label){
		labelDao.update(label);
	}
	
	public void updateIgnoreNull(Label label){
		labelDao.updateIgnoreNull(label);
	}
		
	public void updateByExample(Label label){
		labelDao.update("updateByExampleLabel", label);
	}

	public LabelVo load(Label label){
		return (LabelVo)labelDao.reload(label);
	}
	
	public LabelVo selectForObject(Label label){
		return (LabelVo)labelDao.selectForObject("selectLabel",label);
	}
	
	public List<LabelVo> selectForList(Label label){
		return (List<LabelVo>)labelDao.selectForList("selectLabel",label);
	}
	
	public Page page(Page page, Label label) {
		return labelDao.page(page, label);
	}


	@Autowired
	public void setILabelDao(
			@Qualifier("labelDao") ILabelDao  labelDao) {
		this.labelDao = labelDao;
	}
	

}
