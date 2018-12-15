package com.yizhu.entity;

import com.yizhu.annotation.AutoIncKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Api(description = "用户信息")
@Document(collection = "user")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
