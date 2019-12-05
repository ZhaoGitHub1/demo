package com.yizhu.event;

import com.yizhu.constants.EventTypeEnum;
import com.yizhu.dto.UserDTO;

public class CreateUserEvent extends BaseEvent {

    private UserDTO user;

    public CreateUserEvent(Object source, EventTypeEnum eventType, UserDTO user) {
        super(source, eventType);
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
