package com.yizhu.event;

import com.yizhu.constants.EventTypeEnum;
import org.springframework.context.ApplicationEvent;

public class BaseEvent extends ApplicationEvent {

    private EventTypeEnum eventType;

    public BaseEvent(Object source) {
        super(source);
    }

    public BaseEvent(Object source, EventTypeEnum eventType) {
        super(source);
        this.eventType = eventType;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }
}
