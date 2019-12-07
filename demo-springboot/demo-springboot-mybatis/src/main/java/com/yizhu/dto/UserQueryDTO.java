package com.yizhu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动态查询dto
 */
@ApiModel("用户信息条件查询DTO")
@Data
public class UserQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户年龄")
    private Integer userAge;

    @ApiModelProperty(value = "用户性别")
    private Integer userSex;

    @ApiModelProperty(value = "所属组织id")
    private Long orgId;

    @ApiModelProperty(value = "所属组织名称")
    private String orgName;

}
