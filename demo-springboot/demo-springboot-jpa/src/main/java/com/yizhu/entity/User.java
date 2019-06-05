package com.yizhu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@ApiModel
@Entity
@Table(name = "t_user")
@NamedEntityGraph(name = "User.findUsers", attributeNodes = {@NamedAttributeNode("jobs"), @NamedAttributeNode("roles")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "user_name")
    private String name;

    @ApiModelProperty(value = "用户密码")
    @Column(name = "user_password")
    private String password;

    @ApiModelProperty(value = "用户年龄")
    @Column(name = "user_age")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    @Column(name = "user_sex")
    private Integer sex;

    @ApiModelProperty(value = "所属组织id")
    @Column(name = "org_id")
    private Long orgId;

    @ApiModelProperty(value = "用户信息")
    @OneToOne
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private UserInfo userInfo;

    @ApiModelProperty(value = "用户所属组织")
    @ManyToOne
    @JoinColumn(name = "org_id", updatable = false, insertable = false)
    private Organization org;

    @ApiModelProperty(value = "用户角色")
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Role> roles;

    @ApiModelProperty(value = "用户工作")
    @ManyToMany
    @JoinTable(
            name = "t_user_job",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id")
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Job> jobs;
}

