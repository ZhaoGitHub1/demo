package com.yizhu.constants;

public enum EventTypeEnum {

    CREATE(1,"新增事件"),
    DELETE(2,"删除事件"),
    UPDATE(3,"修改事件"),
    SEARCH(4,"查询事件");

    private int value;

    private String desc;

    EventTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
