package com.selin.store.inveventhis.service.api;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import com.selin.store.invevent.entity.InventoryEventEnum;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inveventhis.entity.InventoryEventHis;
import com.selin.store.inveventhis.entity.InventoryEventHisVo;

public interface IInventoryEventHisService {

    /**
     * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
     */
    public abstract Serializable save(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
     */
    public abstract void delete(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的非空属性作为条件，进行删除
     */
    public abstract void deleteByExample(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
     */
    public abstract void update(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
     */
    public abstract void updateIgnoreNull(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的非空属性作为条件，进行修改
     */
    public abstract void updateByExample(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
     */
    public abstract InventoryEventHisVo load(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的非空属性作为条件，进行查询实体
     */
    public abstract InventoryEventHisVo selectForObject(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的非空属性作为条件，进行查询列表
     */
    public abstract List<InventoryEventHisVo> selectForList(InventoryEventHis inventoryEventHis);

    /**
     * 按对象中的非空属性作为条件，进行分页查询
     */
    public abstract Page page(Page page, InventoryEventHisVo inventoryEventHis);



    /**
     * @param out_warehouse_id
     * @param out_date
     * @param create_user_id
     */
    public void out(Long out_warehouse_id, Date out_date, Long create_user_id,InventoryEventEnum eventEnum,String code);


    public void in(Long in_warehouse_id, Date in_date, Long create_user_id,InventoryEventEnum eventEnum,String code);

    public String createEventCode(InventoryEventEnum eventEnum, Date date);

    Page detailPage(Page page, InventoryEventHisVo inventoryEventHis);
}