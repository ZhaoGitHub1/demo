package com.yizhu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@ApiModel
@Entity
@Table(name = "t_user")
@NamedEntityGraph(name = "User.Graph", attributeNodes = {@NamedAttributeNode("roles")})
@Data
@Builder
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "org_id")
    private Long orgId;

    @ApiModelProperty(value = "用户所属组织")
    @ManyToOne
    @JoinColumn(name = "org_id", updatable = false, insertable = false)
    private Organization org;

    @ApiModelProperty(value = "用户角色")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private Set<User> users;

}

