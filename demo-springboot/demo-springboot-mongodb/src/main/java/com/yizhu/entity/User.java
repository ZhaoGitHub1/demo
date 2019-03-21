package com.yizhu.entity;

import com.yizhu.annotation.AutoIncKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Api(description = "用户信息")
@Document(collection = "user")
@Data
public class User {

    @Id
    @AutoIncKey
    private long id;

    @ApiModelProperty("姓名")
    @Field
    private String name;

    @ApiModelProperty("性别")
    @Field
    private Integer sex;

    @Field
    private UserInfo userInfo;

}
