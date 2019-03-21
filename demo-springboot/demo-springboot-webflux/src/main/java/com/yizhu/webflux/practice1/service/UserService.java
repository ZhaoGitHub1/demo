package com.yizhu.webflux.practice1.service;

import com.yizhu.webflux.practice1.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private Map<String, User> data = new ConcurrentHashMap<>();

    private void userInit(){
        User user1 = User.builder().id("1").name("tom").build();
        User user2 = User.builder().id("2").name("mac").build();
        this.data.put(user1.getId(), user1);
        this.data.put(user2.getId(), user2);
    }

    public Flux<User> list() {
        userInit();
        return Flux.fromIterable(this.data.values());
    }

    public Mono<User> getById(final String id) {
        userInit();
        return Mono.justOrEmpty(this.data.get(id));
    }

    public Mono<User> createOrUpdate(final User user) {
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> delete(final String id) {
        userInit();
        return Mono.justOrEmpty(this.data.remove(id));
    }
}
