package xyz.fusheng.code.springboot.model.plugin.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;

import java.util.Optional;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc SecurityContextHolder
 * @date 2022-12-13 15:37:23
 *
 * Security 上下文持有者
 *
 */

public class UserInfoContextHolder {

    private UserInfoContextHolder() {
    }

    public static CustomUser getCurrentUserInfo() {
        CustomUser customUser = (CustomUser) Optional.of(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).orElse(new CustomUser());
        return customUser;
    }



}

