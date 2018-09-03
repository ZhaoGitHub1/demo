package com.yizhu.webflux.practice1.client;

import com.yizhu.webflux.practice1.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class UserClient {
    public static void main(final String[] args) {
        final User user = new User();
        user.setId("3");
        user.setName("Test");
        final WebClient client = WebClient.create("http://localhost:8080");
        final Mono<User> createdUser = client.post()
                .uri("/user")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .flatMap(response -> response.bodyToMono(User.class));
        System.out.println(createdUser.block());
    }
}