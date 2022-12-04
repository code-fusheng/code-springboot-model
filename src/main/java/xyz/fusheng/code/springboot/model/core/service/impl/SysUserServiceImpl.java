package xyz.fusheng.code.springboot.model.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import xyz.fusheng.code.springboot.core.enums.EnabledStatusEnum;
import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;
import xyz.fusheng.code.springboot.model.core.mapper.SysUserMapper;
import xyz.fusheng.code.springboot.model.core.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统-用户表 服务实现类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username)
                .eq(SysUser::getIsEnabled, EnabledStatusEnum.ENABLED.getCode()));
    }

    @Override
    public List<SysRole> selectRoleByUserId(Long uid) {
        return sysUserMapper.selectRoleByUserId(uid);
    }

    @Override
    public List<SysMenu> selectMenuByUserId(Long uid) {
        return sysUserMapper.selectMenuByUserId(uid);
    }

}
