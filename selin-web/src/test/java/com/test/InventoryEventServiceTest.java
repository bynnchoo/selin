package com.test;

import com.selin.store.invevent.entity.InventoryEvent;
import com.selin.store.invevent.entity.InventoryEventEnum;
import com.selin.store.invevent.entity.InventoryEventVo;
import com.selin.store.invevent.service.api.IInventoryEventService;
import com.selin.store.invevent.service.impl.InventoryEventService;
import com.selin.store.inveventdetail.entity.InventoryEventProDetail;
import com.selin.store.inveventhis.service.api.IInventoryEventHisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/8/16.
 */
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class InventoryEventServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private IInventoryEventService inventoryEventService;
    @Autowired
    private IInventoryEventHisService inventoryEventHisService;

    @Test
    public void test(){
        InventoryEventVo vo = new InventoryEventVo();
        InventoryEventEnum e = InventoryEventEnum.IN_PROCUREMENT;
        vo.setEvent_type(e.getType());
        vo.setEvent(e.name());
        vo.setIn_warehouse_id(1L);
        vo.setIn_date(new Date());
        List<InventoryEventProDetail> details = new ArrayList<>();
        InventoryEventProDetail detail = new InventoryEventProDetail();
        detail.setNum(2);
        detail.setNorm_id(1L);
        InventoryEventProDetail detail1= new InventoryEventProDetail();
        detail1.setNum(12);
        detail1.setNorm_id(2L);
        details.add(detail);
        details.add(detail1);
        vo.setDetails(details);
        vo.setEvent_code(inventoryEventHisService.createEventCode(e, new Date()));

        inventoryEventService.inStock(vo);
    }

    @Test
    public void outTest(){
        InventoryEventVo vo = new InventoryEventVo();
        InventoryEventEnum e = InventoryEventEnum.OUT_SELL;
        vo.setEvent_type(e.getType());
        vo.setEvent(e.name());
        vo.setIn_warehouse_id(1L);
        vo.setIn_date(new Date());
        List<InventoryEventProDetail> details = new ArrayList<>();
        InventoryEventProDetail detail = new InventoryEventProDetail();
        detail.setNum(-2);
        detail.setNorm_id(1L);
        InventoryEventProDetail detail1= new InventoryEventProDetail();
        detail1.setNum(-12);
        detail1.setNorm_id(2L);
        details.add(detail);
        details.add(detail1);
        vo.setDetails(details);
        vo.setEvent_code(inventoryEventHisService.createEventCode(e, new Date()));

        inventoryEventService.inStock(vo);
    }

}
