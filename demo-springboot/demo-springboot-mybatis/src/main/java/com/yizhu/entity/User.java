package com.yizhu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@ApiModel
@TableName(value = "t_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "user_name")
    private String name;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "user_password")
    private String password;

    @ApiModelProperty(value = "用户年龄")
    @TableField(value = "user_age")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    @TableField(value = "user_sex")
    private Integer sex;

    @ApiModelProperty(value = "所属组织id")
    @TableField(value = "org_id")
    private Long orgId;

    @ApiModelProperty(value = "用户信息")
    private UserInfo userInfo;

    @ApiModelProperty(value = "用户所属组织")
    private Organization org;

    @ApiModelProperty(value = "用户角色")
    private List<Role> roles;

    @ApiModelProperty(value = "用户工作")
    private Set<Job> jobs;
}

