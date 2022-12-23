-- 初始化用户
INSERT INTO `code-springboot-model`.`sys_user` (`id`, `uuid`, `username`, `password`, `avatar`, `mobile`, `mail`, `signature`, `description`, `real_name`, `sex`, `address`, `lng`, `lat`, `status`, `remark`, `memo`, `version`, `is_enabled`, `is_deleted`, `creator_id`, `updater_id`, `creator_name`, `updater_name`, `created_at`, `updated_at`) VALUES (1, '1', 'code-fusheng', '$2a$10$pwUFaYUOBy61xI/iBN5HM.AEwnqWKwOJvV3RfuCoGhzHCmqo6cC16', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 0, NULL, NULL, NULL, NULL, '2022-12-04 05:43:22', '2022-12-04 05:43:22');

-- 初始化角色
INSERT INTO `code-springboot-model`.`sys_role` (`id`, `name`, `status`, `remark`, `memo`, `version`, `is_enabled`, `is_deleted`, `creator_id`, `updater_id`, `creator_name`, `updater_name`, `created_at`, `updated_at`) VALUES (1, 'ROOT', NULL, '超级管理员', NULL, 1, 1, 0, NULL, NULL, NULL, NULL, '2022-12-03 09:40:01', '2022-12-03 09:40:01');
INSERT INTO `code-springboot-model`.`sys_role` (`id`, `name`, `status`, `remark`, `memo`, `version`, `is_enabled`, `is_deleted`, `creator_id`, `updater_id`, `creator_name`, `updater_name`, `created_at`, `updated_at`) VALUES (2, 'ADMIN', NULL, '管理员', NULL, 1, 1, 0, NULL, NULL, NULL, NULL, '2022-12-03 09:40:14', '2022-12-03 09:40:14');
INSERT INTO `code-springboot-model`.`sys_role` (`id`, `name`, `status`, `remark`, `memo`, `version`, `is_enabled`, `is_deleted`, `creator_id`, `updater_id`, `creator_name`, `updater_name`, `created_at`, `updated_at`) VALUES (3, 'USER', NULL, '用户', NULL, 1, 1, 0, NULL, NULL, NULL, NULL, '2022-12-03 09:40:26', '2022-12-03 09:40:26');

-- 用户角色关系
INSERT INTO `code-springboot-model`.`sys_user_role_ref` (`user_id`, `role_id`, `creator_id`, `updater_id`, `creator_name`, `updater_name`, `created_at`, `updated_at`) VALUES (1, 1, NULL, NULL, NULL, NULL, '2022-12-04 05:44:03', '2022-12-04 05:44:03');