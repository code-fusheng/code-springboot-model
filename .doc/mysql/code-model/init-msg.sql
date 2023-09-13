CREATE TABLE `msg_channel` (
                               `id` bigint NOT NULL COMMENT '主键',
                               `channel_type` varchar(100) DEFAULT NULL COMMENT '消息渠道类型',
                               `channel_desc` varchar(255) DEFAULT NULL COMMENT '渠道描述',
                               `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                               `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                               `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                               `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                               `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                               `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                               `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                               `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `msg_rule` (
                            `id` bigint NOT NULL COMMENT '主键',
                            `template_id` bigint DEFAULT NULL COMMENT '模版ID',
                            `rule_name` varchar(255) DEFAULT NULL COMMENT '消息规则名称',
                            `rule_desc` varchar(255) DEFAULT NULL COMMENT '规则描述',
                            `is_limit` tinyint(1) DEFAULT '0' COMMENT '是否受限',
                            `send_frequency` varchar(255) DEFAULT NULL COMMENT '发送频率',
                            `send_cycle` varchar(255) DEFAULT NULL COMMENT '发送周期',
                            `send_interval` varchar(255) DEFAULT NULL COMMENT '发送间隔',
                            `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                            `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                            `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                            `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                            `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                            `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                            `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                            `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            `park_id` bigint DEFAULT NULL COMMENT '车场ID',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `msg_send_record` (
                                   `id` bigint NOT NULL COMMENT '主键',
                                   `template_id` varchar(255) DEFAULT NULL COMMENT '消息模版ID',
                                   `template_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '消息模版描述',
                                   `channel_type` varchar(255) DEFAULT NULL COMMENT '消息渠道类型',
                                   `msg_title` varchar(255) DEFAULT NULL COMMENT '消息标题',
                                   `msg_content` varchar(255) DEFAULT NULL COMMENT '消息内容',
                                   `ref_params` varchar(255) DEFAULT NULL COMMENT '相关参数',
                                   `api_response` varchar(255) DEFAULT NULL COMMENT '请求响应',
                                   `result` varchar(255) DEFAULT NULL COMMENT '结果',
                                   `send_time` datetime DEFAULT NULL COMMENT '发送时间',
                                   `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                   `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                                   `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                                   `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                                   `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                                   `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                   `park_id` bigint DEFAULT NULL COMMENT '车场ID',
                                   `receiver_type` varchar(255) DEFAULT NULL COMMENT '接收者类型',
                                   `receiver_key` varchar(255) DEFAULT NULL COMMENT '接受者ID',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `msg_template` (
                                `id` bigint NOT NULL COMMENT '主键',
                                `template_code` varchar(255) DEFAULT NULL COMMENT '模版编号',
                                `template_desc` varchar(255) DEFAULT NULL COMMENT '模版描述',
                                `template_content` varchar(500) DEFAULT NULL COMMENT '模版内容',
                                `content_example` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '内容示例',
                                `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用(1:已启用/0:未启用)',
                                `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除(1:已删除/0:未删除)',
                                `creator_id` bigint DEFAULT NULL COMMENT '创建者编号',
                                `updater_id` bigint DEFAULT NULL COMMENT '修改者编号',
                                `creator_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者姓名',
                                `updater_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改者姓名',
                                `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                `channel_type_id` bigint DEFAULT NULL COMMENT '渠道类型ID',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;