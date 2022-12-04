package xyz.fusheng.code.springboot.model.plugin.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import xyz.fusheng.code.springboot.core.enums.ResultEnum;
import xyz.fusheng.code.springboot.core.exception.BusinessException;
import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.plugin.security.entity.CustomUser;
import xyz.fusheng.code.springboot.model.plugin.security.service.CustomUserDetailsService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc 自定义用户登录验证
 * @date 2022-12-04 13:01:30
 */

@Component
public class CustomUserAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        CustomUser customUser = customUserDetailsService.loadUserByUsername(username);
        if (Objects.isNull(customUser)) {
            throw new BusinessException(ResultEnum.AUTH_FAILED, "用户名不存在!");
        }
        if (!new BCryptPasswordEncoder().matches(password, customUser.getPassword())) {
            throw new BadCredentialsException("密码不正确!");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<SysRole> sysRoleList = customUserDetailsService.selectRoleByUserId(customUser.getId());
        sysRoleList.forEach(sysRole -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + sysRole.getName()));
        });
        customUser.setAuthorities(authorities);
        return new UsernamePasswordAuthenticationToken(customUser, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

