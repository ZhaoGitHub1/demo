package com.yizhu.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "role_id")
    private Long roleId;

}

