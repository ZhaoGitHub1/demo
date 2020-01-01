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
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String userPassword;

    private Integer userAge;

    private Integer userSex;

    private Long orgId;

    private String orgName;

    private Long roleId;

    private String roleName;

}
