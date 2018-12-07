package com.yizhu.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class UserInfo {

    @ApiModelProperty("工作")
    @Field
    private String job;

    @ApiModelProperty("年龄")
    @Field
    private Integer age;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
