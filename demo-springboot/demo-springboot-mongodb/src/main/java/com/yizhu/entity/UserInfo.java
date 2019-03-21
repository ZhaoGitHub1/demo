package com.yizhu.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UserInfo {

    @ApiModelProperty("工作")
    @Field
    private String job;

    @ApiModelProperty("年龄")
    @Field
    private Integer age;

}
