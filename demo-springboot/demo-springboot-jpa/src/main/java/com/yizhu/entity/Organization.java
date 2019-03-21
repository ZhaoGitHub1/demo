package com.yizhu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("用户组织")
@Entity
@Table(name = "t_organization")
@Data
public class Organization implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty("组织名称")
    private String orgName;

}

