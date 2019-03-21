package com.yizhu.webflux.practice1.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String id;

    private String name;

}
