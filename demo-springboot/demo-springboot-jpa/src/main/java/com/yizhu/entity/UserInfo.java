package com.yizhu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel
@Entity
@Table(name = "t_user_info")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "用户id")
    @Column(name = "user_id")
    private Long userId;

    private String address;

}

