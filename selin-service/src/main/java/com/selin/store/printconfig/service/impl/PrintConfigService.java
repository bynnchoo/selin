package com.selin.store.printconfig.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.printconfig.dao.api.IPrintConfigDao;
import com.selin.store.printconfig.entity.PrintConfig;
import com.selin.store.printconfig.entity.PrintConfigVo;
import com.selin.store.printconfig.service.api.IPrintConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrintConfigService implements IPrintConfigService {
	private IPrintConfigDao printConfigDao;

	public Serializable save(PrintConfig printConfig){
		return printConfigDao.save(printConfig);
	}

	public void delete(PrintConfig printConfig){
		printConfigDao.delete(printConfig);
	}
	
	public void deleteByExample(PrintConfig printConfig){
		printConfigDao.deleteByExample(printConfig);
	}

	public void update(PrintConfig printConfig){
		printConfigDao.update(printConfig);
	}
	
	public void updateIgnoreNull(PrintConfig printConfig){
		printConfigDao.updateIgnoreNull(printConfig);
	}
		
	public void updateByExample(PrintConfig printConfig){
		printConfigDao.update("updateByExamplePrintConfig", printConfig);
	}

	public PrintConfigVo load(PrintConfig printConfig){
		return (PrintConfigVo)printConfigDao.reload(printConfig);
	}
	
	public PrintConfigVo selectForObject(PrintConfig printConfig){
		return (PrintConfigVo)printConfigDao.selectForObject("selectPrintConfig",printConfig);
	}
	
	public List<PrintConfigVo> selectForList(PrintConfig printConfig){
		return (List<PrintConfigVo>)printConfigDao.selectForList("selectPrintConfig",printConfig);
	}
	
	public Page page(Page page, PrintConfig printConfig) {
		return printConfigDao.page(page, printConfig);
	}

	@Autowired
	public void setIPrintConfigDao(
			@Qualifier("printConfigDao") IPrintConfigDao  printConfigDao) {
		this.printConfigDao = printConfigDao;
	}
	

}
