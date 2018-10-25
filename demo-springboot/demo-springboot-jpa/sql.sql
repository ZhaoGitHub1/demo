DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_organization
-- ----------------------------
INSERT INTO `t_organization` VALUES ('1', '篮球兴趣组', '2018-10-25 10:48:05', '2018-10-25 10:48:05');
INSERT INTO `t_organization` VALUES ('2', '排球兴趣组', '2018-10-25 10:48:05', '2018-10-25 10:48:05');
INSERT INTO `t_organization` VALUES ('3', '羽毛球兴趣组', '2018-10-25 10:48:05', '2018-10-25 10:48:05');


DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9sof6539ywhxemf6ojn0fqera` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '2018-10-24 17:55:59', '1', null);
INSERT INTO `t_role` VALUES ('2', '邮件系统admin', '2018-10-24 17:55:59', '1', null);
INSERT INTO `t_role` VALUES ('3', '权限系统admin', '2018-10-24 17:55:59', '1', null);
INSERT INTO `t_role` VALUES ('4', '日志系统admin', '2018-10-24 17:55:59', '1', null);
INSERT INTO `t_role` VALUES ('5', '博客系统admin', '2018-10-24 17:55:59', '1', null);


DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_age` int(3) DEFAULT NULL,
  `user_sex` int(2) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjhbxir8ap1btvtafy5hxr1wt9` (`org_id`),
  CONSTRAINT `FKjhbxir8ap1btvtafy5hxr1wt9` FOREIGN KEY (`org_id`) REFERENCES `t_organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '123456', '18', '1', '1', '2018-10-24 18:07:20', '2018-10-24 18:07:20');
INSERT INTO `t_user` VALUES ('2', '李四', '123456', '18', '0', '1', '2018-10-24 18:07:20', '2018-10-24 18:07:20');
INSERT INTO `t_user` VALUES ('3', '王五', '123456', '18', '1', '2', '2018-10-24 18:07:20', '2018-10-24 18:07:20');
INSERT INTO `t_user` VALUES ('4', '赵六', '123456', '18', '1', '1', '2018-10-24 18:07:20', '2018-10-24 18:07:20');


DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`user_id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2018-10-24 18:18:03', '2018-10-24 18:18:03');
INSERT INTO `t_user_role` VALUES ('2', '2', '2', '2018-10-24 18:18:03', '2018-10-24 18:18:03');
INSERT INTO `t_user_role` VALUES ('3', '5', '2', '2018-10-24 18:18:03', '2018-10-24 18:18:03');
INSERT INTO `t_user_role` VALUES ('4', '3', '3', '2018-10-24 18:18:03', '2018-10-24 18:18:03');
INSERT INTO `t_user_role` VALUES ('5', '4', '4', '2018-10-24 18:18:03', '2018-10-24 18:18:03');
