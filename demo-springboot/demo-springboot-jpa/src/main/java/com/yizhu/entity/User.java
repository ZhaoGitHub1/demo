package com.yizhu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel
@Entity
@Table(name = "t_user")
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

//    @ApiModelProperty(value = "用户角色")
//    @OneToMany
//    @JoinColumn(name = "id", updatable = false, insertable = false)
//    private List<Role> roles;

    public User(){}

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, Integer userSex) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
    }

    public User(String userName, String userPassword, Integer userAge, Integer userSex) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }

//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                '}';
    }
}

