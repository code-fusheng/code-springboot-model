DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `uuid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一ID',
                            `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                            `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                            `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
                            `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码',
                            `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
                            `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '签名',
                            `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
                            `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
                            `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 0:私密 1:男 2:女',
                            `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
                            `lng` decimal(16,6) DEFAULT NULL COMMENT '经度',
                            `lat` decimal(16,6) DEFAULT NULL COMMENT '纬度',
                            `status` tinyint(1) DEFAULT NULL COMMENT '状态',
                            `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                            `memo` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '拓展',
                            `version` int NOT NULL DEFAULT '1' COMMENT '乐观锁 默认1',
                            `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                            `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                            `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                            `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                            `creator_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                            `updater_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                            `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统-用户表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
                            `status` tinyint(1) DEFAULT NULL COMMENT '状态',
                            `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                            `memo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '拓展',
                            `version` int NOT NULL DEFAULT '1' COMMENT '乐观锁 默认1',
                            `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                            `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                            `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                            `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                            `creator_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                            `updater_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                            `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统-角色表';

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名称',
                            `permission` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识',
                            `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限路由',
                            `pid` bigint NOT NULL DEFAULT '0' COMMENT '父级id',
                            `level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '权限级别 1 菜单 2 列表 3 接口',
                            `status` tinyint(1) DEFAULT NULL COMMENT '状态',
                            `is_white` tinyint(1) DEFAULT '0' COMMENT '是否白名单(1:是/0:否)',
                            `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                            `memo` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '拓展',
                            `version` int NOT NULL DEFAULT '1' COMMENT '乐观锁 默认1',
                            `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                            `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                            `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                            `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                            `creator_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                            `updater_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                            `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统-权限表';

DROP TABLE IF EXISTS `sys_user_role_ref`;
CREATE TABLE `sys_user_role_ref` (
                                     `user_id` bigint NOT NULL COMMENT '用户ID',
                                     `role_id` bigint NOT NULL COMMENT '角色ID',
                                     `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                                     `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                                     `creator_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                                     `updater_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                                     `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                     PRIMARY KEY (`user_id`,`role_id`),
                                     UNIQUE KEY `idx_user_role` (`user_id`,`role_id`) COMMENT '联合主键索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统-用户-角色关联表';

DROP TABLE IF EXISTS `sys_role_menu_ref`;
CREATE TABLE `sys_role_menu_ref` (
                                     `role_id` bigint(20) NOT NULL COMMENT '角色ID',
                                     `menu_id` bigint(20) NOT NULL COMMENT '权限ID',
                                     `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                                     `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                                     `creator_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                                     `updater_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                                     `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                     PRIMARY KEY (`role_id`,`menu_id`),
                                     UNIQUE KEY `idx_role_menu` (`role_id`,`menu_id`) COMMENT '联合主键索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与权限关系表';

DROP TABLE IF EXISTS `code_model`;
CREATE TABLE `code_model` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `model_name` varchar(255) DEFAULT NULL COMMENT '模版名称',
                              `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                              `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '拓展',
                              `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                              `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                              `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                              `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                              `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                              `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                              `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `code_model_plus`;
CREATE TABLE `code_model_plus` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `model_plus_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                   `model_plus_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                   `model_plus_tags` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                   `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                   `memo` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '拓展',
                                   `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                                   `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                                   `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                                   `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                                   `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                                   `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                                   `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;