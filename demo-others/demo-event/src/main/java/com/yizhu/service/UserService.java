package com.yizhu.service;

import com.yizhu.constants.EventTypeEnum;
import com.yizhu.dto.UserDTO;
import com.yizhu.event.CreateUserEvent;
import com.yizhu.publisher.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    UserEventPublisher userEventPublisher;

    public UserDTO createUser(){
        UserDTO user = UserDTO.builder()
                .name("张三")
                .age(18)
                .build();

        CreateUserEvent event = new CreateUserEvent(user, EventTypeEnum.CREATE, user);
        applicationEventPublisher.publishEvent(event);


        return user;
    }
}
