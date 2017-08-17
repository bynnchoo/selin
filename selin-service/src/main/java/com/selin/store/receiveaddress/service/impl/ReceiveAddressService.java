package com.selin.store.receiveaddress.service.impl;

import java.io.Serializable;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.area.service.api.IAreaService;
import com.selin.store.receiveaddress.dao.api.IReceiveAddressDao;
import com.selin.store.receiveaddress.entity.ReceiveAddress;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.receiveaddress.service.api.IReceiveAddressService;

@Service
public class ReceiveAddressService implements IReceiveAddressService {
	private IReceiveAddressDao receiveAddressDao;

	@Autowired
	private IAreaService areaService;

	public Serializable save(ReceiveAddress receiveAddress) {
		return receiveAddressDao.save(receiveAddress);
	}

	public void delete(ReceiveAddress receiveAddress) {
		receiveAddressDao.delete(receiveAddress);
	}

	public void deleteByExample(ReceiveAddress receiveAddress) {
		receiveAddressDao.deleteByExample(receiveAddress);
	}

	public void update(ReceiveAddress receiveAddress) {
		receiveAddressDao.update(receiveAddress);
	}

	public void updateIgnoreNull(ReceiveAddress receiveAddress) {
		receiveAddressDao.updateIgnoreNull(receiveAddress);
	}

	public void updateByExample(ReceiveAddress receiveAddress) {
		receiveAddressDao.update("updateByExampleReceiveAddress", receiveAddress);
	}

	public ReceiveAddressVo load(ReceiveAddress receiveAddress) {
		ReceiveAddressVo v = (ReceiveAddressVo) receiveAddressDao.reload(receiveAddress);
		if (v.getArea_id() != null) {
			v.setArea_name(areaService.findPathtoroot(v.getArea_id()));
		}
		return v;
	}

	public ReceiveAddressVo selectForObject(ReceiveAddress receiveAddress) {
		return (ReceiveAddressVo) receiveAddressDao.selectForObject("selectReceiveAddress", receiveAddress);
	}

	@SuppressWarnings("unchecked")
	public List<ReceiveAddressVo> selectForList(ReceiveAddress receiveAddress) {
		List<ReceiveAddressVo> list = (List<ReceiveAddressVo>) receiveAddressDao.selectForList("selectReceiveAddress",
				receiveAddress);
		for (ReceiveAddressVo receiveAddressVo : list) {
			if (receiveAddressVo.getArea_id() != null) {
				receiveAddressVo.setArea_name(areaService.findPathtoroot(receiveAddressVo.getArea_id()));
			}
		}
		return list;
	}

	public Page page(Page page, ReceiveAddress receiveAddress) {
		return receiveAddressDao.page(page, receiveAddress);
	}

	@Autowired
	public void setIReceiveAddressDao(@Qualifier("receiveAddressDao") IReceiveAddressDao receiveAddressDao) {
		this.receiveAddressDao = receiveAddressDao;
	}

}
