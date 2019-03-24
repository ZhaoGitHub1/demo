package com.yizhu.publisher;

import com.yizhu.event.BaseEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserEventPublisher<T extends BaseEvent> implements ApplicationEventPublisherAware {

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    }
}
