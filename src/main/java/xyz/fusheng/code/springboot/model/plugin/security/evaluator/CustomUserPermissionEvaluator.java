package xyz.fusheng.code.springboot.model.plugin.security.evaluator;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;
import xyz.fusheng.code.springboot.model.plugin.security.service.CustomUserDetailsService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc CustomUserPermissionEvaluator
 * @date 2022-12-04 14:11:29
 */

@Component
public class CustomUserPermissionEvaluator implements PermissionEvaluator {

    @Resource
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        // 获取用户信息
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        // 查询用户权限（这里可以将权限放入缓存提高效率）
        Set<String> permissions = new HashSet<>();
        List<SysMenu> sysMenuList = customUserDetailsService.selectMenuByUserId(customUser.getId());
        for (SysMenu sysMenu : sysMenuList) {
            permissions.add(sysMenu.getPermission());
        }
        // 权限对比
        if (permissions.contains(permission.toString())){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}

