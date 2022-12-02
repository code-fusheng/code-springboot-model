package xyz.fusheng.code.springboot.model.core.service.impl;

import xyz.fusheng.code.springboot.model.model.entity.SysRole;
import xyz.fusheng.code.springboot.model.core.mapper.SysRoleMapper;
import xyz.fusheng.code.springboot.model.core.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统-角色表 服务实现类
 * </p>
 *
 * @author code-fusheng
 * @since 2022-12-01
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}
