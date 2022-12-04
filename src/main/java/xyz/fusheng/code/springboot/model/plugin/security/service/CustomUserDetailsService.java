package xyz.fusheng.code.springboot.model.plugin.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.fusheng.code.springboot.core.enums.ResultEnum;
import xyz.fusheng.code.springboot.core.exception.BusinessException;
import xyz.fusheng.code.springboot.model.core.service.ISysUserService;
import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 自定义用户信息业务层
 * @date 2022-12-04 12:42:22
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private ISysUserService iSysUserService;

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = iSysUserService.selectUserByUsername(username);
        if (Objects.isNull(sysUser)) {
            throw new BusinessException(ResultEnum.USERNAME_OR_PASSWORD_ERROR, "用户信息不存在!");
        }
        CustomUser customUser = new CustomUser();
        BeanUtils.copyProperties(sysUser, customUser);
        return customUser;
    }

    public List<SysRole> selectRoleByUserId(Long uid) {
        return iSysUserService.selectRoleByUserId(uid);
    }

    public List<SysMenu> selectMenuByUserId(Long uid) {
        return iSysUserService.selectMenuByUserId(uid);
    }

}

