package xyz.fusheng.code.springboot.model.core.service;

import xyz.fusheng.code.springboot.model.model.entity.SysMenu;
import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.model.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统-用户表 服务类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser selectUserByUsername(String username);

    List<SysRole> selectRoleByUserId(Long uid);

    List<SysMenu> selectMenuByUserId(Long uid);
}
