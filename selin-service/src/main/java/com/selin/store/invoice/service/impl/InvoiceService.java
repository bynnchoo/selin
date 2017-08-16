package com.selin.store.invoice.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.invoice.dao.api.IInvoiceDao;
import com.selin.store.invoice.entity.Invoice;
import com.selin.store.invoice.entity.InvoiceVo;
import com.selin.store.invoice.service.api.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
	private IInvoiceDao invoiceDao;

	public Serializable save(Invoice invoice){
		return invoiceDao.save(invoice);
	}

	public void delete(Invoice invoice){
		invoiceDao.delete(invoice);
	}
	
	public void deleteByExample(Invoice invoice){
		invoiceDao.deleteByExample(invoice);
	}

	public void update(Invoice invoice){
		invoiceDao.update(invoice);
	}
	
	public void updateIgnoreNull(Invoice invoice){
		invoiceDao.updateIgnoreNull(invoice);
	}
		
	public void updateByExample(Invoice invoice){
		invoiceDao.update("updateByExampleInvoice", invoice);
	}

	public InvoiceVo load(Invoice invoice){
		return (InvoiceVo)invoiceDao.reload(invoice);
	}
	
	public InvoiceVo selectForObject(Invoice invoice){
		return (InvoiceVo)invoiceDao.selectForObject("selectInvoice",invoice);
	}
	
	public List<InvoiceVo> selectForList(Invoice invoice){
		return (List<InvoiceVo>)invoiceDao.selectForList("selectInvoice",invoice);
	}
	
	public Page page(Page page, Invoice invoice) {
		return invoiceDao.page(page, invoice);
	}

	@Autowired
	public void setIInvoiceDao(
			@Qualifier("invoiceDao") IInvoiceDao  invoiceDao) {
		this.invoiceDao = invoiceDao;
	}
	

}
