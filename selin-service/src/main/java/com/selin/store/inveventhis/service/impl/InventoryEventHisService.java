package com.selin.store.inveventhis.service.impl;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.selin.store.invevent.entity.InventoryEvent;
import com.selin.store.invevent.entity.InventoryEventEnum;
import org.roof.commons.RoofDateUtils;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inveventhis.dao.api.IInventoryEventHisDao;
import com.selin.store.inveventhis.entity.InventoryEventHis;
import com.selin.store.inveventhis.entity.InventoryEventHisVo;
import com.selin.store.inveventhis.service.api.IInventoryEventHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryEventHisService implements IInventoryEventHisService {
    private IInventoryEventHisDao inventoryEventHisDao;

    private RedisTemplate redisTemplate;

    public Serializable save(InventoryEventHis inventoryEventHis) {
        return inventoryEventHisDao.save(inventoryEventHis);
    }

    public void delete(InventoryEventHis inventoryEventHis) {
        inventoryEventHisDao.delete(inventoryEventHis);
    }

    public void deleteByExample(InventoryEventHis inventoryEventHis) {
        inventoryEventHisDao.deleteByExample(inventoryEventHis);
    }

    public void update(InventoryEventHis inventoryEventHis) {
        inventoryEventHisDao.update(inventoryEventHis);
    }

    public void updateIgnoreNull(InventoryEventHis inventoryEventHis) {
        inventoryEventHisDao.updateIgnoreNull(inventoryEventHis);
    }

    public void updateByExample(InventoryEventHis inventoryEventHis) {
        inventoryEventHisDao.update("updateByExampleInventoryEventHis", inventoryEventHis);
    }

    public InventoryEventHisVo load(InventoryEventHis inventoryEventHis) {
        return (InventoryEventHisVo) inventoryEventHisDao.reload(inventoryEventHis);
    }

    public InventoryEventHisVo selectForObject(InventoryEventHis inventoryEventHis) {
        return (InventoryEventHisVo) inventoryEventHisDao.selectForObject("selectInventoryEventHis", inventoryEventHis);
    }

    public List<InventoryEventHisVo> selectForList(InventoryEventHis inventoryEventHis) {
        return (List<InventoryEventHisVo>) inventoryEventHisDao.selectForList("selectInventoryEventHis", inventoryEventHis);
    }

    public Page page(Page page, InventoryEventHisVo inventoryEventHis) {
        return inventoryEventHisDao.page(page, inventoryEventHis);
    }

    @Override
    public Page detailPage(Page page, InventoryEventHisVo inventoryEventHis) {
        return inventoryEventHisDao.detailPage(page, inventoryEventHis);
    }

    private InventoryEventHis getInventoryEventHis(Long create_user_id, InventoryEventEnum eventEnum) {
        InventoryEventHis inventoryEventHis = new InventoryEventHis();
        inventoryEventHis.setCreate_date(new Date());
        inventoryEventHis.setCreate_user_id(create_user_id);
        inventoryEventHis.setEvent_type(eventEnum.getType());
        inventoryEventHis.setEvent(eventEnum.name());
        return inventoryEventHis;
    }




    public void out(Long out_warehouse_id, Date out_date, Long create_user_id,InventoryEventEnum eventEnum,String code) {
        InventoryEventHis inventoryEventHis = getInventoryEventHis(create_user_id, eventEnum);
        inventoryEventHis.setOut_date(new Date());
        inventoryEventHis.setOut_warehouse_id(out_warehouse_id);
        inventoryEventHis.setEvent_code(code);
        this.save(inventoryEventHis);
    }

    public void in(Long in_warehouse_id, Date in_date, Long create_user_id,InventoryEventEnum eventEnum,String code) {
        InventoryEventHis inventoryEventHis = getInventoryEventHis(create_user_id, eventEnum);
        inventoryEventHis.setIn_date(in_date);
        inventoryEventHis.setIn_warehouse_id(in_warehouse_id);
        inventoryEventHis.setEvent_code(code);
        this.save(inventoryEventHis);
    }

    public String createEventCode(InventoryEventEnum eventEnum, Date date) {
        String key = eventEnum.getType() + "-" + RoofDateUtils.dateToString(date, "yyyyMMdd");
        BoundValueOperations<String, Long> operations = redisTemplate.boundValueOps(key);//.increment(1);
        Long l = operations.increment(1);
        operations.expire(2, TimeUnit.DAYS);
        int i = new SecureRandom().nextInt();
        String s = "00000" + l;
        s = s.substring(s.length() - 6, s.length());
        String str = key + "-" + s;
        return str;
    }


    @Autowired
    public void setIInventoryEventHisDao(
            @Qualifier("inventoryEventHisDao") IInventoryEventHisDao inventoryEventHisDao) {
        this.inventoryEventHisDao = inventoryEventHisDao;
    }
    @Autowired
    public void setRedisTemplate(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
