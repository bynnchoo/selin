package com.selin.store.invevent.entity;

/**
 * Created by zhenglt on 2017/8/13.
 */
public enum InventoryEventEnum {

    IN_PROCUREMENT("采购入库", "IN"),
    IN_BACK("退货", "IN"),
    IN_ALLOT("调拨入库", "IN"),
    IN_OTHER("其他入库", "IN"),
    IN_PROFIT("盘盈", "IN"),

    OUT_SELL("销售", "OUT"),
    OUT_ALLOT("调拨", "OUT"),
    OUT_BACK("采购退回", "OUT"),
    OUT_OTHER("采购退回", "OUT"),
    OUT_LOSS("盘亏", "OUT"),

    SUBSCRIBE("预约", "SUBSCRIBE");

    private String display;
    private String type;


    private InventoryEventEnum(String display, String type) {
        this.display = display;
        this.type = type;
    }


    public String getDisplay() {
        return display;
    }

    public String getType() {
        return type;
    }
}

